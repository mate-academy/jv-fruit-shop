package core.basesyntax.service;

import core.basesyntax.dao.FruitRecordDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.validator.Validator;
import java.util.ArrayList;
import java.util.List;

public class ParserCsvImpl implements Parser {
    public static final List<FruitRecordDto> fruitStore = new ArrayList<>();
    private static final String COMA = ",";

    @Override
    public void parse(String[] lines) {
        for (String line : lines) {
            if (Validator.isValidLine(line.split(COMA))) {
                FruitRecordDto fruit = parseTransaction(line);
                fruitStore.add(fruit);
            } else {
                continue;
            }
        }
    }

    private FruitRecordDto parseTransaction(String line) {
        String[] lines = line.split(COMA);
        return new FruitRecordDto(OperationType.getType(lines[0]),
                new Fruit(lines[1]), Integer.parseInt(lines[2]));
    }
}
