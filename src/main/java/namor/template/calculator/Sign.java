package namor.template.calculator;

public enum Sign {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    String key;

    Sign(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static Sign getValue(String key) {
        if (ADDITION.getKey().equals(key)) { return Sign.ADDITION; }
        else if (SUBTRACTION.getKey().equals(key)) { return Sign.SUBTRACTION; }
        else if (MULTIPLICATION.getKey().equals(key)) { return Sign.MULTIPLICATION; }
        else if (DIVISION.getKey().equals(key)) { return Sign.DIVISION; }
        else throw new IllegalArgumentException("Input elements are wrong!");
    }
}
