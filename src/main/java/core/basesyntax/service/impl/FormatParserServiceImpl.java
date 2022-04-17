package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FormatParserService;
import java.util.ArrayList;
import java.util.List;

public class FormatParserServiceImpl implements FormatParserService {
    private static final String COMMA = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public List<FruitTransaction> parseData(String csvFormatData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String[] splittedDataBySeparator = csvFormatData.split(LINE_SEPARATOR);
        for (int i = 1; i < splittedDataBySeparator.length; i++) {
            String[] splittedByComma = splittedDataBySeparator[i].split(COMMA);

            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .valueOfOperation(splittedByComma[0]));
            fruitTransaction.setFruit(splittedByComma[1]);
            fruitTransaction.setQuantity(Integer.parseInt(splittedByComma[2]));

            fruitTransactions.add(fruitTransaction);
        }

        return fruitTransactions;
    }
}
