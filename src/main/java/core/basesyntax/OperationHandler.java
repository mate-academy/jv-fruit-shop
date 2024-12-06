package core.basesyntax;

public abstract class OperationHandler {
    private FruitTransfer fruitTransfer;

    public void setFruitTransfer(FruitTransfer fruitTransfer) {
        this.fruitTransfer = fruitTransfer;
    }

    public abstract void makeOperation();

    public String getFruit() {
        return fruitTransfer.getFruit();
    }

    public int getQuantity() {
        return fruitTransfer.getQuantity();
    }
}

