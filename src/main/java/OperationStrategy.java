import operationhandler.OperationHandler;

public interface OperationStrategy {

    OperationHandler getOperation(String operation);

}
