package demo.q3min.enums;

public enum QuestionType {
    SHORT("단답식"), LONG("주관식");

    private final String value;

    QuestionType(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
