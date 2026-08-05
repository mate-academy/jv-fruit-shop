package core.basesyntax.strategy;

public interface Transaction {
    void process(String fruitName, int amount);
}
