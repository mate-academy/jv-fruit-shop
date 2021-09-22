package core.basesyntax.parser;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import core.basesyntax.model.TransactionDto;
import java.util.List;
import java.util.stream.Collectors;

public class FruitRecordParserImpl implements FruitRecordParser {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int FRUITS_AMOUNT = 2;

    @Override
    public List<TransactionDto> parse(List<String> records) {
        return records.stream()
                .map(l -> l.split(","))
                .map(r -> new TransactionDto(OperationType.getEnumValue(r[OPERATION_TYPE]),
                        new Fruit(r[FRUIT_NAME]),
                        Integer.parseInt(r[FRUITS_AMOUNT])))
                .collect(Collectors.toList());
    }
}
