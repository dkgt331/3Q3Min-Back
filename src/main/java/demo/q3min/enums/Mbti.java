package demo.q3min.enums;

public enum Mbti {
    ISTJ("ISTJ"), ISTP("ISTP"), ISFJ("ISFJ"), ISFP("ISFP"),
    INTJ("INTJ"), INTP("INTP"), INFJ("INFJ"), INFP("INFP"),
    ESTJ("ESTJ"), ESTP("ESTP"), ESFJ("ESFJ"), ESFP("ESFP"),
    ENTJ("ENTJ"), ENTP("ENTP"), ENFJ("ENFJ"), ENFP("ENFP");

    private String value;

    Mbti(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
