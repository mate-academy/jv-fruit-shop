package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA = ",";
    private static final int MAGIC_NUMBER_ONE = 1;
    private static final int OPERATION_TYPE = 0;
    private static final int OPERATION_FRUIT = 1;
    private static final int OPERATION_QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        return lines.stream()
                .skip(MAGIC_NUMBER_ONE)
                .map(line -> line.split(COMMA))
                .map(parts -> new FruitTransaction(FruitTransaction.Operation
                                .getByCode(parts[OPERATION_TYPE].trim()),
                        parts[OPERATION_FRUIT].trim(),
                        Integer.parseInt(parts[OPERATION_QUANTITY].trim())))
                .toList();
    }
}
