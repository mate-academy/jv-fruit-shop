package core.basesyntax.models;

public class Fruit {
    private Type typeOfFruit;

    public void setTypeOfFruit(Type typeOfFruit) {
        this.typeOfFruit = typeOfFruit;
    }

    public Type getTypeOfFruit() {
        return typeOfFruit;
    }

    public enum Type {
        APPLE("apple"),
        BANANA("banana");
        private final String code;

        Type(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Type setType(String code) {
            for (Type type : values()) {
                if (type.code.equals(code)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("No enum constant with code: " + code);
        }
    }
}
