package core.basesyntax.dto;

import core.basesyntax.model.OperationType;

import java.util.List;
import java.util.stream.Collectors;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final long START_LINE = 1;
    private static final String COMMA = ",";
    private static final int INDEX_OF_TYPE = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_AMOUNT = 2;

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        return lines.stream()
                .skip(START_LINE)
                .map(this::parseRecord)
                .collect(Collectors.toList());
    }

    private FruitRecordDto parseRecord(String record) {
        String[] records = record.split(COMMA);
        if (records.length != 3) {
            throw new RuntimeException("Invalid data");
        }
        OperationType operationType = OperationType.getOperationTypeByLetter(records[INDEX_OF_TYPE]);
        long amount = Integer.parseInt(records[INDEX_OF_AMOUNT]);
        if (amount < 0) {
            throw new RuntimeException("Invalid amount");
        }
        return new FruitRecordDto(operationType, records[INDEX_OF_FRUIT], amount);
    }
}
