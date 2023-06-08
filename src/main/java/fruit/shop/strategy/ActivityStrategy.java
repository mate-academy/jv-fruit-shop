package fruit.shop.strategy;

public interface ActivityStrategy {
    int handleTransaction(String option, int currentValue, int value);
}
