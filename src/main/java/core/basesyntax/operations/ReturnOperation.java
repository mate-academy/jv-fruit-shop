package core.basesyntax.operations;

public class ReturnOperation implements Operation {

    @Override
    public int calculateAmount(int oldAmount, int amount) {
        if (amount < 0) {
            throw new RuntimeException("Amount can't be less than zero");
        }
        return oldAmount + amount;
    }
}
