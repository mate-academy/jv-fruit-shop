package service.impl;

import model.FruitTransaction;
import service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(line -> line.split(","))
                .map(parts -> new FruitTransaction(FruitTransaction.Operation.getByCode(parts[0].trim()),
                        parts[1].trim(), Integer.parseInt(parts[2].trim())))
                .toList();
    }
}
