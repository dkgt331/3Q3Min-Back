package demo.q3min.enums;

public enum QuestionCategory {
    DAILY("일상");

    private final String value;

    QuestionCategory(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
