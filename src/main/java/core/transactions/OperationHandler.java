package core.transactions;

public interface OperationHandler {
    int getTransaction(int currentAmount, int operationAmount);
}
