package core.basesyntax.operationstrategy;

import core.basesyntax.dao.FruitRecordsDaoImpl;
import core.basesyntax.model.TransactionDto;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public Integer doOperation(TransactionDto transactionDto) {
        return new FruitRecordsDaoImpl().getAll().get(transactionDto.getFruit())
                + transactionDto.getFruitAmount();
    }
}
