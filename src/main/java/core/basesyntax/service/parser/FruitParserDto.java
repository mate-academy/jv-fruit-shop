package core.basesyntax.service.parser;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.operations.Operation;
import core.basesyntax.validate.Validator;
import core.basesyntax.validate.ValidatorOfData;
import java.util.ArrayList;
import java.util.List;

public class FruitParserDto implements Parser {
    private static final String EXCEPTION_MESSAGE = "Illegal argument";
    private static final String TITLE = "type,fruit,quantity";
    private static final String SPLIT_STRING = ",";
    private static final Integer OPERATION = 0;
    private static final Integer FRUIT = 1;
    private static final Integer QUANTITY = 2;

    @Override
    public List<FruitDto> parseInformation(List<String> fruitList) {
        List<FruitDto> fruitDtoList = new ArrayList<>();
        Validator validator = new ValidatorOfData();
        for (String line : fruitList) {
            if (line.equals(TITLE)) {
                continue;
            }
            String[] parsedLine = line.split(SPLIT_STRING);
            if (validator.validationData(parsedLine[OPERATION],
                    parsedLine[FRUIT],
                    parsedLine[QUANTITY])) {
                Operation operation = findOperation(parsedLine[OPERATION].trim());
                String fruitName = parsedLine[FRUIT];
                Integer countChange = Integer.parseInt(parsedLine[QUANTITY]);
                FruitDto newFruit = new FruitDto(operation, fruitName, countChange);
                fruitDtoList.add(newFruit);
            }
        }
        return fruitDtoList;
    }

    private Operation findOperation(String operation) {
        if (Operation.BALANCE.getOperation().equals(operation)) {
            return Operation.BALANCE;
        } else if (Operation.PURCHASE.getOperation().equals(operation)) {
            return Operation.PURCHASE;
        } else if (Operation.RETURN.getOperation().equals(operation)) {
            return Operation.RETURN;
        } else if (Operation.SUPPLY.getOperation().equals(operation)) {
            return Operation.SUPPLY;
        } else {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
    }
}
