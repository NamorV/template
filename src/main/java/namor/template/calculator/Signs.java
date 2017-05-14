package namor.template.calculator;

public enum Signs {
    ADDITION("+"),
    SUBSTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    String key;

    Signs(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
