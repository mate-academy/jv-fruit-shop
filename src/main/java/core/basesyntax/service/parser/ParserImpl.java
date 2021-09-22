package core.basesyntax.service.parser;

import core.basesyntax.exception.ValidationException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperationDto;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.parser.validator.FruitOperationDtoValidator;
import core.basesyntax.service.parser.validator.Validator;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser<List<String>, List<FruitOperationDto>> {
    private static final int TYPE_OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLITERATOR_REGEX = ",";

    @Override
    public List<FruitOperationDto> parse(List<String> list) {
        Validator validator = new FruitOperationDtoValidator();
        List<FruitOperationDto> fruitOperationDtoList = new ArrayList<>();
        String[] spliterator;
        for (String line : list) {
            try {
                validator.validate(line);
            } catch (ValidationException e) {
                throw new RuntimeException("Data is not valid: " + line, e);
            }
            spliterator = line.split(SPLITERATOR_REGEX);
            fruitOperationDtoList.add(new FruitOperationDto(
                    OperationType.valueOfLabel(spliterator[TYPE_OPERATION_INDEX]),
                    new Fruit(spliterator[FRUIT_INDEX]),
                    Integer.parseInt(spliterator[QUANTITY_INDEX])));
        }
        return fruitOperationDtoList;
    }
}
