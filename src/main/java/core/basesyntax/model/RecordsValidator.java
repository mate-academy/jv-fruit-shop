package core.basesyntax.model;

public interface RecordsValidator {
    Record validate(String operationType, String fruitName, String quantity);
}
