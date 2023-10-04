package core.basesyntax.service.interfaces.strategy;

public interface TransactionHandler {
    Integer getCurrentQuantity(Integer currentQuantity, Integer newQuantity);
}
