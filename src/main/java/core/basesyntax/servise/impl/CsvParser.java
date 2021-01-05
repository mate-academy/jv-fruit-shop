package core.basesyntax.servise.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.servise.FileParser;
import java.util.ArrayList;
import java.util.List;

public class CsvParser implements FileParser<TransactionDto> {
    private static final String DELIMITER = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;

    @Override
    public List<TransactionDto> parseData(List<String> list) {
        List<TransactionDto> dtoList = new ArrayList<>();
        for (String line : list) {
            String[] split = line.split(DELIMITER);
            TransactionDto dto = new TransactionDto(
                    Operation.fromString(split[OPERATION]),
                    new Fruit(split[FRUIT]),
                    Integer.parseInt(split[AMOUNT]));
            dtoList.add(dto);
        }
        return dtoList;
    }
}
