package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.DataConverter;
import service.Parser;

public class DataConverterImpl implements DataConverter {
    public static final int NUMBER_OF_SKIP = 1;
    private Parser<FruitTransaction> parser = new ParserImpl();

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputData) {
        return inputData.stream()
                .skip(NUMBER_OF_SKIP)
                .map(parser::parse)
                .toList();
    }
}
