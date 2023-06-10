package fruit.shop.service.strategy;

public interface ActivityStrategy {
    int handleTransaction(String option, int currentValue, int value);
}
