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

    Signs getAction(String x){
        if ("+".equals(x)){
            return ADDITION;
        } else if ("-".equals(x)){
            return SUBSTRACTION;
        } else if ("*".equals(x)){
            return MULTIPLICATION;
        } else if ("/".equals(x)){
            return DIVISION;
        } else throw new IllegalArgumentException();
    }
}
