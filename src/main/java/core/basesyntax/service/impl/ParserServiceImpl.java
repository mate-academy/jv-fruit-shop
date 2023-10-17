package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String COMA = ",";

    @Override
    public List<FruitTransaction> parseObjectsFromStrings(List<String> strings) {
        return strings.stream().map(this::getFruitFromString).collect(Collectors.toList());
    }

    private FruitTransaction getFruitFromString(String string) {
        String [] parts = string.split(COMA);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(parts[0]);
        fruitTransaction.setFruit(parts[1]);
        fruitTransaction.setQuantity(Integer.parseInt(parts[2]));
        return fruitTransaction;
    }
}
