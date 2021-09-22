package core.basesyntax.servises;

public interface OperationHandler {
    void apply(TransferDto transferDto, Storage<String, Integer> storage);
}
