package core.basesyntax.services.implementation;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TypeOfOperation;
import core.basesyntax.services.FruitDtoParser;
import core.basesyntax.services.Validator;
import java.util.ArrayList;
import java.util.List;

public class FruitDtoParserImpl implements FruitDtoParser {
    private static final String COMMA = ",";
    private static final int TYPE_OF_OPERATION_INDEX = 0;
    private static final int NAME_OF_FRUIT_INDEX = 1;
    private static final int AMOUNT_OF_FRUIT_INDEX = 2;
    private final Validator validator = new ValidatorImpl();

    @Override
    public List<FruitDto> parseFruitDto(List<String> dataFromFile) {
        dataFromFile.remove(TYPE_OF_OPERATION_INDEX);
        List<FruitDto> parsedFruits = new ArrayList<>();
        String[] lineFromFile;
        for (String line : dataFromFile) {
            validator.validate(line);
            lineFromFile = line.split(COMMA);
            parsedFruits.add(new FruitDto(TypeOfOperation
                    .getOperation(lineFromFile[TYPE_OF_OPERATION_INDEX]),
                    new Fruit(lineFromFile[NAME_OF_FRUIT_INDEX]),
                    Integer.parseInt(lineFromFile[AMOUNT_OF_FRUIT_INDEX])));
        }
        return parsedFruits;
    }
}
