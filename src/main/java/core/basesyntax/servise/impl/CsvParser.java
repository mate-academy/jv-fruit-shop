package core.basesyntax.servise.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.servise.FileParser;
import java.util.ArrayList;
import java.util.List;

public class CsvParser implements FileParser<TransactionDto> {
    private static final String DELIMITER = ",";

    @Override
    public List<TransactionDto> parseData(List<String> list) {
        List<TransactionDto> dtoList = new ArrayList<>();
        for (String line : list) {
            String[] split = line.split(DELIMITER);
            TransactionDto dto = new TransactionDto(
                    Operation.fromString(split[0]),
                    new Fruit(split[1]),
                    Integer.parseInt(split[2]));
            dtoList.add(dto);
        }
        return dtoList;
    }
}
