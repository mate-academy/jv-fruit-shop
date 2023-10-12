package fruit.shop.strategy;

public interface OperationStrategy {
    OperationHandler get(String type);
}
