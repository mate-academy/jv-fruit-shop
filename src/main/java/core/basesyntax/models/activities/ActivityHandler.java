package core.basesyntax.models.activities;

public interface ActivityHandler {
    Integer apply(Integer currentQuantity, Integer operationQuantity);

    default void validatePositiveResult(int result) {
        if (result < 0) {
            throw new RuntimeException("Not enough product in Storage");
        }
    }
}
