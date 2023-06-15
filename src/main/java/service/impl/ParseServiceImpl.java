package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ParseService;

public class ParseServiceImpl implements ParseService {
    public static final String SPLITTER_COMMA = ",";
    public static final int TYPE_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseFruitTransaction(List<String> records) {
        return records.stream()
                .skip(0)
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(SPLITTER_COMMA);
        return new FruitTransaction(FruitTransaction.Operation.getByCode(fields[TYPE_INDEX]),
                fields[FRUIT_INDEX], Integer.parseInt(fields[QUANTITY_INDEX]));
    }
}

