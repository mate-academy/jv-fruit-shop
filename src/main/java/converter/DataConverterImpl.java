package converter;

import java.util.List;
import model.FruitTransaction;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int OFFSET = 1;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> converterToTransaction(List<String> data) {
        return data.stream()
                .skip(OFFSET)
                .map(line -> {
                    String[] parts = line.split(SEPARATOR);
                    FruitTransaction.Operation operation =
                            FruitTransaction.Operation.fromCode(parts[OPERATION_INDEX]);
                    return new FruitTransaction(operation, parts[FRUIT_NAME_INDEX],
                            Integer.parseInt(parts[QUANTITY_INDEX]));
                })
                .toList();
    }
}

