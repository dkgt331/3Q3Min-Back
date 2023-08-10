package demo.q3min.config;


import demo.q3min.config.jwt.JwtAuthenticationFilter;
import demo.q3min.config.jwt.JwtAuthorizationFilter;
import demo.q3min.config.oauth.CustomAuthorizationRequestRepository;
import demo.q3min.config.oauth.CustomOAuth2UserService;
import demo.q3min.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomOAuth2UserService principalOauth2UserService;

    @Autowired
    private CorsConfig corsConfig;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomAuthorizationRequestRepository customAuthorizationRequestRepository;


    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/login", "/join", "/").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((formLogin) -> formLogin.disable())
                .httpBasic((httpBasic) -> httpBasic.disable())
                .oauth2Login((oauth2Login) ->
                        oauth2Login
                                .authorizationEndpoint(authorization -> authorization
                                        .authorizationRequestRepository(customAuthorizationRequestRepository))
                                .userInfoEndpoint(userInfoEndpointConfig -> userInfoEndpointConfig.userService(principalOauth2UserService))
                );
        http.apply(new CustomFilter());
        return http.build();
    }

    public class CustomFilter extends AbstractHttpConfigurer<CustomFilter, HttpSecurity> {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
            http
                    .addFilter(corsConfig.corsFilter())
                    .addFilterBefore(new JwtAuthenticationFilter(authenticationManager, userRepository), BasicAuthenticationFilter.class)
                    .addFilter(new JwtAuthorizationFilter(authenticationManager, userRepository));
        }
    }

}
