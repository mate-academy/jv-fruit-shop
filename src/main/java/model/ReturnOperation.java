package model;

public class ReturnOperation extends TransactionOperation {
    public ReturnOperation(String code) {
        super(code);
    }

    public ReturnOperation() {
        super("r");
    }
}
