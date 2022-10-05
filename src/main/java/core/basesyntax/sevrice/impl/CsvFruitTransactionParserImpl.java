package core.basesyntax.sevrice.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.sevrice.CsvFruitTransactionParser;
import java.util.ArrayList;
import java.util.List;

public class CsvFruitTransactionParserImpl implements CsvFruitTransactionParser {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int HEADER_INDEX = 0;
    private static final int AMOUNT = 2;
    private static final String DELIMITER = ",";

    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        dataFromFile.remove(HEADER_INDEX);
        return new ArrayList<>() {
            {
                for (String line : dataFromFile) {
                    add(createTransaction(line.split(DELIMITER)));
                }
            }
        };
    }

    private FruitTransaction createTransaction(String[] splitedString) {
        return new FruitTransaction(
                FruitTransaction.Operation.getByOperation(splitedString[OPERATION]),
                new Fruit(splitedString[FRUIT]),
                Integer.parseInt(splitedString[AMOUNT]));
    }
}
