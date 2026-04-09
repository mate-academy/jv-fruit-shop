package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        return data.stream()
                .skip(1) // заголовок CSV
                .map(line -> {
                    String[] p = line.split(",");
                    return new FruitTransaction(FruitTransaction.Operation.fromCode(p[0]),
                            p[1], Integer.parseInt(p[2]));
                }).toList();
    }
}
