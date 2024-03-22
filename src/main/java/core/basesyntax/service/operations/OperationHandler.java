package core.basesyntax.service.operations;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.exeptions.UnsupportedOperationExeption;

public interface OperationHandler {
    void apply(FruitTransactionDto dto) throws UnsupportedOperationExeption;

    boolean isApplicable(FruitTransactionDto dto);
}
