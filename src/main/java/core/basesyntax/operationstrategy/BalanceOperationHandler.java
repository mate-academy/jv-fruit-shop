package core.basesyntax.operationstrategy;

import core.basesyntax.model.TransactionDto;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer doOperation(TransactionDto fruitRecord) {
        int fruitsBalance = fruitRecord.getFruitAmount();
        if (fruitsBalance < 0) {
            throw new RuntimeException("Incorrect morning balance of fruits: "
                    + fruitRecord
                    + ". Not enough fruits to open shop");
        }
        return fruitRecord.getFruitAmount();
    }
}
