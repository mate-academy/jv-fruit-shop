package converter;

import java.util.List;
import model.FruitTransaction;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> converterToTransaction(List<String> data) {
        return data.stream()
                .skip(1)
                .map(line -> {
                    String[] parts = line.split(",");
                    FruitTransaction.Operation operation
                            = FruitTransaction.Operation.fromCode(parts[OPERATION_INDEX]);
                    return new FruitTransaction(operation, parts[FRUIT_NAME_INDEX],
                            Integer.parseInt(parts[QUANTITY_INDEX]));
                })
                .toList();
    }
}
