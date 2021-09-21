package core.basesyntax.operationstrategy;

import core.basesyntax.dao.FruitRecordsDaoImpl;
import core.basesyntax.model.TransactionDto;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Integer doOperation(TransactionDto transactionDto) {
        int fruitsQuantityAfterBuy = new FruitRecordsDaoImpl().getAll()
                .get(transactionDto.getFruit()) - transactionDto.getFruitAmount();
        if (fruitsQuantityAfterBuy < 0) {
            throw new RuntimeException("Incorrect operation: "
                    + transactionDto
                    + ". Not enough fruits to buy");
        }
        return fruitsQuantityAfterBuy;
    }
}
