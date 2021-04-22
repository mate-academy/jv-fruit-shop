package core.basesyntax.operations;

public class PurchaseOperation implements Operation {
    @Override
    public int calculateAmount(int oldAmount, int amount) {
        if (oldAmount - amount < 0) {
            throw new RuntimeException("There is only " + oldAmount
                    + " of product, you can't buy more!");
        }
        return oldAmount - amount;
    }
}
