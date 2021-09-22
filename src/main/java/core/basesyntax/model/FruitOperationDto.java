package core.basesyntax.model;

public class FruitOperationDto {
    private Type type;
    private String fruitName;
    private int quantity;

    public FruitOperationDto(Type type, String fruitName, int quantity) {
        this.type = type;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum Type {
        BALANCE("b"),
        PURCHASE("p"),
        RETURN("r"),
        SUPPLY("s");

        private final String label;

        private Type(String label) {
            this.label = label;
        }

        public static Type valueOfLabel(String label) {
            for (Type type : values()) {
                if (type.label.equals(label)) {
                    return type;
                }
            }
            throw new RuntimeException("Can't find type of operation " + label);
        }
    }
}
