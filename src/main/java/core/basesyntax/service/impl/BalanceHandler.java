package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitOperationHandler;
import java.util.Map;

public class BalanceHandler implements FruitOperationHandler {
    private static final String SEPARATOR = System.getProperty("line.separator");

    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        int newQuantity = fruitRecordDto.getQuantity();
        Storage.fruits.put(fruit, newQuantity);
        return newQuantity;
    }

    public String writeBalance(Map<Fruit, Integer> balance) {
        StringBuilder balanceFruit = new StringBuilder();
        balanceFruit.append("fruit").append(',').append("quantity").append(SEPARATOR);
        for (Map.Entry<Fruit, Integer> entry :balance.entrySet()) {
            balanceFruit.append(entry.getKey().getName())
                    .append(',')
                    .append(entry.getValue().toString())
                    .append(SEPARATOR);
        }
        return balanceFruit.toString();
    }
}
