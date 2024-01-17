package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReporterService;
import core.basesyntax.service.OperationServiceStrategy;
import java.util.List;
import java.util.function.Consumer;

public class CsvFileReporterServiceImpl implements FileReporterService, Consumer<String> {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private OperationServiceStrategy operationStrategy;
    private Storage storage;

    public CsvFileReporterServiceImpl(OperationServiceStrategy operationStrategy, Storage storage) {
        this.operationStrategy = operationStrategy;
        this.storage = storage;
    }

    @Override
    public void getReport(List<String> readFile) {
        readFile
                .stream()
                .forEach(this);
    }

    private void changeValueDependingOnOperation(FruitTransaction transaction) {
        storage.getFruitQuantityMap().put(transaction.getFruit(),
                operationStrategy.getOperationHandler(transaction.getOperation())
                                .handle(transaction, storage));
    }

    @Override
    public void accept(String operation) {
        String[] dividedByComma = operation.split(COMMA);
        FruitTransaction transaction;
        int quantity;
        try {
            quantity = Integer.parseInt(dividedByComma[QUANTITY_INDEX]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(
                    "third parameter in every line of file should be quantity, but was "
                            + dividedByComma[QUANTITY_INDEX]);
        }
        if (quantity <= 0) {
            throw new NumberFormatException(
                    "input quantity should be not less than 0, but was "
                            + quantity);
        }
        transaction = new FruitTransaction(
                FruitTransaction.Operation.fromString(dividedByComma[OPERATION_INDEX]),
                dividedByComma[FRUIT_NAME_INDEX],
                quantity);
        changeValueDependingOnOperation(transaction);
    }
}
