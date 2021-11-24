package service.implement;
import core.basesyntax.model.Fruit;
import service.ParceOutputValueService;

import java.util.List;

public class ParceOutputValue implements ParceOutputValueService {
    public String storageToString(List<Fruit> storage){
        outputString.append("fruit,quantity");
        for (Fruit fruit: storage) {
outputString.append(System.lineSeparator()).append(fruit.getName()).append(",").append(fruit.getNumber());
        }

        return outputString.toString();
    }
}
