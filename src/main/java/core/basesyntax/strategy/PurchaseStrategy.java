package core.basesyntax.strategy;

import core.basesyntax.basesyntaxdb.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.DateValidation;
import core.basesyntax.service.impl.DateValidationImpl;

public class PurchaseStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        for (int i = 0; i < transactionDto.getQuantity(); i++) {
            DateValidation dateValidation = new DateValidationImpl();
            dateValidation.validation(transactionDto);
            Storage.fruitList.remove(transactionDto.getFruit());
        }
    }
}
