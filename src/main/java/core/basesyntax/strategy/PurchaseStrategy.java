package core.basesyntax.strategy;

import core.basesyntax.basesyntaxdb.Storage;
import core.basesyntax.exception.OverBuyException;
import core.basesyntax.model.TransactionDto;

public class PurchaseStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        for (int i = 0; i < transactionDto.getQuantity(); i++) {
            validation(transactionDto);
            Storage.fruitList.remove(transactionDto.getFruit());
        }
    }

    private void validation(TransactionDto transactionDto) {
        int amountCurrentFruits = (int) Storage.fruitList.stream()
                .filter(e -> e.getName().equals(transactionDto.getFruit().getName())).count();
        if (amountCurrentFruits < transactionDto.getQuantity()) {
            throw new OverBuyException("We can't sale this quantity of fruit");
        }
    }
}
