package core.basesyntax.strategy;

public interface ITransactionsHandler<FruitTransaction> {
    boolean handle(FruitTransaction fruitTransaction);
}
