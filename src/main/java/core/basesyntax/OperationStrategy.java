package core.basesyntax;

public abstract class OperationStrategy {
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

