package core.basesyntax.dto;

import core.basesyntax.service.OperationType;
import core.basesyntax.service.OperatorParse;
import core.basesyntax.service.implementation.OperatorParseImpl;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParseImpl implements FruitRecordDtoParse {
    private static final String DELIMITER = ",";

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        List<FruitRecordDto> fruitRecordDtos = new ArrayList<>();
        for (String line : lines) {
            OperatorParse operatorParse = new OperatorParseImpl();
            String[] lineInfo = line.split(DELIMITER);
            OperationType operation = operatorParse.parse(lineInfo[0]);
            String fruitName = lineInfo[1];
            int amount = Integer.parseInt(lineInfo[2]);
            fruitRecordDtos.add(new FruitRecordDto(operation, fruitName, amount));
        }
        return fruitRecordDtos;
    }
}
