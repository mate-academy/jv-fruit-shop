package service.impl;

import model.FruitTransaction;
import service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";
    private static final int MAGIC_NUMBER = 1;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        return lines.stream()
                .skip(MAGIC_NUMBER)
                .map(line -> line.split(SEPARATOR))
                .map(parts -> new FruitTransaction(FruitTransaction.Operation.getByCode(parts[0].trim()),
                        parts[1].trim(), Integer.parseInt(parts[2].trim())))
                .toList();
    }
}
