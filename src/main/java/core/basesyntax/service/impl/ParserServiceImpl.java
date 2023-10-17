package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    @Override
    public List<FruitTransaction> getObjectsFromStrings(List<String> strings) {
        return strings.stream().map(this::getFruitFromString).collect(Collectors.toList());
    }

    private FruitTransaction getFruitFromString(String string) {
        String [] parts = string.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.valueOf(parts[0]));
        fruitTransaction.setFruit(parts[1]);
        fruitTransaction.setQuantity(Integer.parseInt(parts[2]));
        return fruitTransaction;
    }
}
