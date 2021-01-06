package core.basesyntax.service.impl;

import core.basesyntax.basesyntaxdb.Storage;
import core.basesyntax.exception.OverBuyException;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.DataValidation;

public class DataValidationImpl implements DataValidation {
    public void validation(TransactionDto transactionDto) {
        int amountCurrentFruits = (int) Storage.fruitList.stream()
                .filter(e -> e.getName().equals(transactionDto.getFruit().getName())).count();
        if (amountCurrentFruits < transactionDto.getQuantity()) {
            throw new OverBuyException("We can't sale this quantity of fruit");
        }
    }
}
