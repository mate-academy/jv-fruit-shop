package core.basesyntax.model;

public class FruitTransaction {
    private String operation;
    private Fruit fruit;
    private Integer count;

    public FruitTransaction(String operation, Fruit fruit, Integer count) {
        this.operation = operation;
        this.fruit = fruit;
        this.count = count;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "FruitTransition{"
                + "operation='" + operation + '\''
                + ", fruit=" + fruit
                + ", count=" + count
                + '}';
    }

    public enum FruitOperation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String firstLetter;

        FruitOperation(String firstLetter) {
            this.firstLetter = firstLetter;
        }

        public String getFirstLetter() {
            return firstLetter;
        }
    }
}
