package core.basesyntax.models.activities;

public interface ActivityHandler {
    Integer apply(Integer currentQuantity, Integer operationQuantity);
}
