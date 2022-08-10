package core.basesyntax.service.data;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class CsvDataServiceImpl implements DataService<String> {
    public static final int INDEX_OPERATION = 0;
    public static final int INDEX_FRUIT = 1;
    public static final int INDEX_QUANTITY = 2;

    @Override
    public List<FruitTransaction> processData(List<String> list) {
        return list.stream()
                .map(this::parser).collect(Collectors.toList());
    }

    public FruitTransaction parser(String row) {
        String[] fields = row.split(",");
        return new FruitTransaction(fields[INDEX_OPERATION], fields[INDEX_FRUIT],
                Integer.parseInt(fields[INDEX_QUANTITY]));
    }
}
