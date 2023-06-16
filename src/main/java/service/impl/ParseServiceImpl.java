package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final String CSV_DELIMITER = ",";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> records) {
        return records.subList(1, records.size()).stream()
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(CSV_DELIMITER);
        return new FruitTransaction(FruitTransaction.Operation.getByCode(fields[TYPE_INDEX]),
                fields[FRUIT_INDEX], Integer.parseInt(fields[QUANTITY_INDEX]));
    }
}
