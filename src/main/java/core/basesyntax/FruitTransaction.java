package core.basesyntax;

public class FruitTransaction {
    private Operation operation;
    private String nameOfProduct;
    private int number;

    public enum Operation {
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

    public FruitTransaction(Operation operation, String nameOfProduct, int number) {
        this.operation = operation;
        this.nameOfProduct = nameOfProduct;
        this.number = number;
    }

    public Operation getOperation() {
        return operation;
    }

    public static Operation convertFromCode(String code) {
        Operation[] operations = Operation.values();
        for (Operation operation : operations) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        return null;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setProduct(String product) {
        this.nameOfProduct = product;
    }


}
