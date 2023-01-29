package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CalculateService;
import java.util.List;

public class CalculateServiceImpl implements CalculateService {

    @Override
    public void calculateQuantity(List<String> listOfOperations) {
        String[] parser;
        for (int i = 1; i < listOfOperations.size(); i++) {
            parser = listOfOperations.get(i).split(",");
            String operation = parser[0];
            String fruits = parser[1];
            int number = Integer.parseInt(parser[2]);
            switch (operation) {
                case "b":
                    Storage.fruits.put(fruits, number);
                    break;
                case "p":
                    Storage.fruits.replace(fruits, Storage.fruits.get(fruits) - number);
                    break;
                default:
                    Storage.fruits.replace(fruits, Storage.fruits.get(fruits) + number);
                    break;
            }
        }
    }
}
