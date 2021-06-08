package core.basesyntax.operations;

public class ReturnOperation implements Operation {
    @Override
    public int calculateAmount(int oldAmount, int amount) {
        return oldAmount + amount;
    }
}
