package core.basesyntax.operations;

public class SupplyOperation implements Operation {
    @Override
    public int calculateAmount(int oldAmount, int amount) {
        return oldAmount + amount;
    }
}
