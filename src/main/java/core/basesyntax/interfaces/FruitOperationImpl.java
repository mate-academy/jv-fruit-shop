package core.basesyntax.interfaces;

import core.basesyntax.FruitRecord;
import java.util.Map;

public class FruitOperationImpl implements FruitOperation {

    @Override
    public void process(FruitRecord record, Map<String, Integer> stock) {

        stock.putIfAbsent(record.getFruit(), 0);
        int current = stock.get(record.getFruit());

        switch (record.getOperation()) {
            case "b":
                stock.put(record.getFruit(), record.getQuantity());
                break;
            case "s":
            case "r":
                stock.put(record.getFruit(), current + record.getQuantity());
                break;
            case "p":
                stock.put(record.getFruit(), current - record.getQuantity());
                break;
            default:
                System.out.println("There is a problem with data!");
        }
    }
}
