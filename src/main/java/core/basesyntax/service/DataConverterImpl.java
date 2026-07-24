package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.parse.OperationParser;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR =",";
    private final OperationParser operationParser;

    public DataConverterImpl(OperationParser operationParser) {
        this.operationParser = operationParser;
    }

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> reportData) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < reportData.size(); i++) {
            String[] parts = reportData.get(i).split(SEPARATOR);

            FruitTransaction transaction = new FruitTransaction(
                    operationParser.getOperation(parts[0]),
                    parts[1],
                    Integer.parseInt(parts[2])
            );

            transactions.add(transaction);
        }
        return transactions;
    }
}
