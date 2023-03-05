package core.basesyntax.service;

public enum Operation {
    BALANCE("b", FruitsDirection.INCOMING.fruitsDirection),
    SUPPLY("s", FruitsDirection.INCOMING.fruitsDirection),
    PURCHASE("p", FruitsDirection.OUTGOING.fruitsDirection),
    RETURN("r", FruitsDirection.INCOMING.fruitsDirection);

    private String transaction;
    private int direction;

    Operation(String transaction, int direction) {
        this.transaction = transaction;
        this.direction = direction;
    }

    public String getTransaction() {
        return transaction;
    }

    public int getFruitDirection() {
        return direction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    private enum FruitsDirection {
        INCOMING(1),
        OUTGOING(-1);
        private final int fruitsDirection;

        FruitsDirection(int fruitsDirection) {
            this.fruitsDirection = fruitsDirection;
        }
    }
}
