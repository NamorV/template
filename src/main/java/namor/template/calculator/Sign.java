package namor.template.calculator;

public enum Sign {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    NUMBER(" ");

    String key;

    Sign(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static Sign getValue(String key) {
        for(Sign sign : Sign.values()){
            if (sign.getKey().equals(key)){
                return sign;
            }
        }
        return NUMBER;
    }
}
