package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvParserImpl implements CsvParser {

    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<TransactionDto> parse(List<String> input) {
        List<String[]> dataCollection = input.stream()
                .map(l -> l.split(","))
                .collect(Collectors.toList());
        List<TransactionDto> data = new ArrayList<>();
        for (String[] line : dataCollection.subList(1, dataCollection.size())) {
            data.add(createDtoFromData(line));
        }
        return data;
    }

    private TransactionDto createDtoFromData(String[] data) {
        Operation operation = Operation.fromString(data[OPERATION_INDEX]);
        Fruit fruit = new Fruit(data[FRUIT_INDEX]);
        Integer quantity = Integer.parseInt(data[QUANTITY_INDEX]);
        if (quantity < 0) {
            throw new RuntimeException("We can't operate with negative amount!");
        }
        return new TransactionDto(operation, fruit, quantity);
    }
}
