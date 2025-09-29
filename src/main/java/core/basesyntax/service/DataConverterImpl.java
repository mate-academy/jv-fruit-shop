package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATE_SYMBOL = ",";
    private static final Integer OPERATION_INDEX = 0;
    private static final Integer FRUIT_NAME_INDEX = 1;
    private static final Integer COUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        if (lines == null) {
            throw new RuntimeException("Input list cannot be null");
        }
        for (int i = 1; i < lines.size(); i++) {
            String[] data = lines.get(i).split(SEPARATE_SYMBOL);
            FruitTransactionService transactionService = new FruitTransactionServiceImpl();
            transactionService.createTransaction(Operation.fromCode(data[OPERATION_INDEX].trim()),
                    data[FRUIT_NAME_INDEX].trim(),
                    Integer.parseInt(data[COUNT_INDEX].trim()));
        }
        return Storage.getRecords();
    }
}
