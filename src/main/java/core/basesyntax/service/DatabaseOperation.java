package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;
import exceptions.IllegalTransactionException;

public interface DatabaseOperation {
    int apply(FruitRecordDto fruitRecordDto);

    default void validate(int input, int result) {
        if (input < 0 || result < 0) {
            throw new IllegalTransactionException("Transaction is impossible");
        }
    }
}
