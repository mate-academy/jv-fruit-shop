package fruitshop.strategy.operation;

public interface OperationHandler {
    Integer handle(Integer prevQuantity, Integer quantity);
}
