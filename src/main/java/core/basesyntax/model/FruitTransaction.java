package core.basesyntax.model;

public interface FruitTransaction {
    enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    Operation getOperation();

    void setOperation(Operation operation);

    String getFruit();

    void setFruit(String fruit);

    int getQuantity();

    void setQuantity(int quantity);
}
