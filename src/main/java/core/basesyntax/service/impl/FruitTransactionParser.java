package core.basesyntax.service.impl;

import core.basesyntax.model.OperationType;
import core.basesyntax.model.impl.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.util.CsvRowValidator;
import core.basesyntax.service.util.TransactionSplitter;

public class FruitTransactionParser implements TransactionParser<FruitTransaction> {

    @Override
    public FruitTransaction parse(String row) {
        if (row == null || !CsvRowValidator.validate(row)) {
            throw new RuntimeException("Invalid data in row: " + row);
        }
        return new FruitTransaction(OperationType
                .getByCode(TransactionSplitter.getOperationType(row)),
                TransactionSplitter.getProductType(row),
                TransactionSplitter.getOperationValue(row));
    }
}
