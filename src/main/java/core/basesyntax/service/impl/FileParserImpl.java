package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.FileParser;
import java.util.List;
import java.util.stream.Collectors;

public class FileParserImpl implements FileParser {

    @Override
    public List<FruitOperation> parse(List<String> inputList) {
        return inputList.stream()
                .skip(1)
                .map(this::parserToObject)
                .collect(Collectors.toList());
    }

    private FruitOperation parserToObject(String raw) {
        String[] parts = raw.split(",");
        if (parts[0].isEmpty() || parts[0].isBlank() || parts[0] == null) {
            throw new RuntimeException("Don't have operation for current type activity" + parts[0]);
        }
        if (parts[1].isEmpty() || parts[1].isBlank() || parts[1] == null) {
            throw new RuntimeException("The Fruit is null" + parts[1]);
        }
        if (Integer.parseInt(parts[2]) == 0 || Integer.parseInt(parts[2]) < 0) {
            throw new RuntimeException("Don't correct quantity" + parts[2]);
        }
        return new FruitOperation(TypeActivity.typeGiven(parts[0]),
                new Fruit(parts[1]), Integer.parseInt(parts[2]));
    }
}
