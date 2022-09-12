package core.basesyntax.service.cvs;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.List;
import java.util.stream.Collectors;

public class CsvParserServiceImpl implements CsvParserService {
    private static final int HEADER_ROW = 1;
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_TYPE = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        return data.stream()
                .skip(HEADER_ROW)
                .map(this::parseCsvRowToTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseCsvRowToTransaction(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruit = new FruitTransaction();
        fruit.setOperation(Operation.getOperationEnum(fields[INDEX_OPERATION]));
        fruit.setName(fields[INDEX_TYPE]);
        fruit.setQuantity(Integer.parseInt(fields[INDEX_QUANTITY]));
        return fruit;
    }
}
