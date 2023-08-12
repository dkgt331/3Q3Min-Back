package demo.q3min.enums;

public enum ServiceProvider {
    GOOGLE("GOOGLE"), KAKAO("KAKAO"), NAVER("NAVER");

    private final String value;

    ServiceProvider(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
