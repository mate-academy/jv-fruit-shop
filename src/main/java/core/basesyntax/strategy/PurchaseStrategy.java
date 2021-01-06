package core.basesyntax.strategy;

import core.basesyntax.basesyntaxdb.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.DataValidation;
import core.basesyntax.service.impl.DataValidationImpl;

public class PurchaseStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        for (int i = 0; i < transactionDto.getQuantity(); i++) {
            DataValidation dateValidation = new DataValidationImpl();
            dateValidation.validation(transactionDto);
            Storage.fruitList.remove(transactionDto.getFruit());
        }
    }
}
