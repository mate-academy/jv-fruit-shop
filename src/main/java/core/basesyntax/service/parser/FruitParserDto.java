package core.basesyntax.service.parser;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.dto.StorageFruitDto;
import core.basesyntax.operations.Operation;
import core.basesyntax.validate.Validation;
import core.basesyntax.validate.ValidationOfData;
import java.util.List;

public class FruitParserDto implements Parser {
    private static final String SKIP_TITLE = "type,fruit,quantity";
    private static final String SPLIT_STRING = ",";

    @Override
    public List<FruitDto> parseInformation(List<String> fruitList) {
        Validation validation = new ValidationOfData();
        for (String line : fruitList) {
            if (line.equals(SKIP_TITLE)) {
                continue;
            }
            String[] parsedLine = line.split(SPLIT_STRING);
            if (validation.validationData(parsedLine[0], parsedLine[1], parsedLine[2])) {
                Operation operation = findOperation(parsedLine[0].trim());
                String fruitName = parsedLine[1];
                Integer countChange = Integer.parseInt(parsedLine[2]);
                FruitDto newFruit = new FruitDto(operation, fruitName, countChange);
                StorageFruitDto.fruitAndActionList.add(newFruit);
            }
        }
        return StorageFruitDto.fruitAndActionList;
    }

    private Operation findOperation(String operation) {
        if ("b".equals(operation)) {
            return Operation.b;
        } else if ("p".equals(operation)) {
            return Operation.p;
        } else if ("r".equals(operation)) {
            return Operation.r;
        } else if ("s".equals(operation)) {
            return Operation.s;
        } else {
            return null;
        }
    }
}
