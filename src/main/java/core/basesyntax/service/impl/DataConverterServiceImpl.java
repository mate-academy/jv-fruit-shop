package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverterService;
import java.util.ArrayList;
import java.util.List;

public class DataConverterServiceImpl implements DataConverterService {
    private static final int POSITION_OPERATION = 0;
    private static final int POSITION_FRUIT_TYPE = 1;
    private static final int POSITION_QUANTITY = 2;
    private static final String REGEX_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convert(List<String> data) {
        if (data == null) {
            throw new RuntimeException("Data list can't be null");
        }
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String line = data.get(i);
            if (line == null || line.isBlank()) {
                throw new RuntimeException("Data in fruitTransactions can't be null or empty");
            }
            String[] splitLine = line.split(REGEX_SEPARATOR);
            if (splitLine.length != 3) {
                throw new RuntimeException("Not valid csv format at line: "
                        + line + ", with index: " + i);
            }
            String operationCode = splitLine[POSITION_OPERATION].trim();
            String fruitName = splitLine[POSITION_FRUIT_TYPE].trim();
            String quantityString = splitLine[POSITION_QUANTITY].trim();
            try {
                int quantity = Integer.parseInt(quantityString);
                FruitTransaction.Operation operation = FruitTransaction
                        .Operation
                        .fromCode(operationCode);
                fruitTransactions.add(new FruitTransaction(operation, fruitName, quantity));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Not valid quantity: " + quantityString
                        + "in line: " + line
                        + ", with index: " + i, e);
            }
        }
        return fruitTransactions;
    }
}
