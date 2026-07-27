package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.parse.OperationParser;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    private final OperationParser operationParser;

    public DataConverterImpl(OperationParser operationParser) {
        this.operationParser = operationParser;
    }

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> reportData) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < reportData.size(); i++) {
            String[] parts = reportData.get(i).split(SEPARATOR);

            transactions.add(new FruitTransaction(
                    operationParser.getOperation(parts[OPERATION_INDEX]),
                    parts[FRUIT_INDEX],
                    Integer.parseInt(parts[QUANTITY_INDEX])
            ));
        }
        return transactions;
    }
}
