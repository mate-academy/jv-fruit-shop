package services.impl;

import java.io.IOException;
import java.util.List;
import model.FruitTransaction;
import services.interfaces.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final int CODE = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;

    @Override
    public List<FruitTransaction> convertToFruitTransaction(List<String> list) throws IOException {
        return list.stream()
                .skip(1)
                .map(line -> line.split(","))
                .map(record -> new FruitTransaction(
                        FruitTransaction.Operation.from(record[CODE]),
                        record[FRUIT],
                        Integer.parseInt(record[AMOUNT]))
                ).toList();
    }
}
