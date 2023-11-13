package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvParser;
import java.util.List;
import java.util.stream.Collectors;

public class CsvParserImpl implements CsvParser {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_AMOUNT = 2;
    private static final int INDEX_FROM_CSV_SKIP = 1;
    private static final String SEPARATOR = ",";

    @Override
    public List<TransactionDto> parse(List<String> transactions) {
        return transactions.stream()
                .skip(INDEX_FROM_CSV_SKIP)
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private TransactionDto getFromCsvRow(String line) {
        String[] fields = line.split(SEPARATOR);
        String operation = fields[INDEX_OPERATION].trim();
        String fruit = fields[INDEX_FRUIT];
        int amount = Integer.parseInt(fields[INDEX_AMOUNT]);
        return new TransactionDto(TransactionDto.Operation.getByCode(operation), fruit, amount);
    }
}
