package demo.q3min.config.oauth;


import demo.q3min.config.auth.PrincipalDetails;
import demo.q3min.entity.User;
import demo.q3min.enums.ServiceProvider;
import demo.q3min.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired
    public UserRepository userRepository;

    // 구글로부터 받은 유저 데이터를 후처리하는 함수
    // 해당 함수가 종료될 때 @AuthenticationPrincipal 어노테이션이 만들어진다.
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oauth2User = super.loadUser(userRequest);

        // 회원가입을 강제로 진행
        String provider = userRequest.getClientRegistration().getClientId();    // google, naver, ...
        String providerId = oauth2User.getAttribute("sub");
        String username = "google_" + providerId;
        String email = oauth2User.getAttribute("email");
        String role = "ROLE_USER";

        User userEntity = userRepository.findByUsername(username);

        // 최초 구글로그인 -> 자동 회원가입 진행
        if (userEntity == null) {
            userEntity = new User(email, username, provider, role);
            userRepository.save(userEntity);
        }

        return new PrincipalDetails(userEntity, oauth2User.getAttributes());
    }
}
