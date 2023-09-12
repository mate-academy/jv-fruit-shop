package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.CsvParserService;
import java.util.List;

public class CsvParserImpl implements CsvParserService {
    private static final int HEADER_ROW_COUNT = 1;
    private static final int OPERATION_CODE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parse(List<String> fruitsList) {
        return fruitsList.stream()
                .skip(HEADER_ROW_COUNT)
                .map(s -> s.split(SEPARATOR))
                .map(CsvParserImpl::getByRow)
                .toList();
    }

    private static FruitTransaction getByRow(String... row) {
        Operation operation = Operation.getByCode(row[OPERATION_CODE_INDEX]);
        Fruit fruit = new Fruit(row[FRUIT_INDEX]);
        int amount = Integer.parseInt(row[AMOUNT_INDEX]);
        return new FruitTransaction(operation, fruit, amount);
    }
}
