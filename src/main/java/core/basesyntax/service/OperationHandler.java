package core.basesyntax.service;

public interface OperationHandler {
    int handle(int oldAmount, int quantityFromTransaction);
}
