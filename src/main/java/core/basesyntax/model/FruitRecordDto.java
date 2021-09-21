package core.basesyntax.model;

public class FruitRecordDto {
    private Type typeOfOperation;
    private Fruit fruit;
    private Integer amount;

    public FruitRecordDto() {
    }

    public FruitRecordDto(Type typeOfOperation, Fruit fruit, Integer amount) {
        this.typeOfOperation = typeOfOperation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Type getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(Type typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public enum Type {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String label;

        Type(String label) {
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
