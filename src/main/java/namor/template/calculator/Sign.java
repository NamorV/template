package namor.template.calculator;

public enum Sign {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    String key;

    Sign(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static Sign getValue(String key) {
        for (Sign sign : Sign.values()) {
            if (sign.getKey().equals(key)) {
                return sign;
            }
        }
        throw new IllegalArgumentException("Input elements are wrong!");
    }

    public static boolean isSign(String key) {
        for (Sign sign : Sign.values()) {
            if (sign.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }
}
