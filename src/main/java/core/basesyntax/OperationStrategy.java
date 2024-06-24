public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
