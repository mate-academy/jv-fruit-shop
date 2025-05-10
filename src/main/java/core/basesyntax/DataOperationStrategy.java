package core.basesyntax;

public interface DataOperationStrategy {
    void execute(FruitTransaction transaction, FruitDB fruitDB);
}
