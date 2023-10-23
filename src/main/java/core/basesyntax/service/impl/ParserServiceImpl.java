package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String COMA = ",";

    @Override
    public List<FruitTransaction> parseObjectsFromStrings(List<String> strings) {
        if (strings == null) {
            throw new RuntimeException("Cannot parse null");
        }
        return strings.stream().map(this::getFruitFromString).collect(Collectors.toList());
    }

    private FruitTransaction getFruitFromString(String string) {
        String [] parts = string.split(COMA);
        return FruitTransaction.of(Operation.getOperationFromString(parts[0]),
                        parts[1], Integer.parseInt(parts[2]));
    }

}
