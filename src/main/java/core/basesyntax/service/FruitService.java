package core.basesyntax.service;

import core.basesyntax.model.FruitBox;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FruitService {

    public List<Operation> parseOperations(List<String> list) {
        List<Operation> result = new ArrayList<>();
        Operation operation;
        FruitBox fruitBox;
        for (String line : list) {
            String[] parts = line.split(",");
            if (parts.length < 4) {
                continue;
            }
            String fruitName = parts[1];
            int amount = Integer.parseInt(parts[2]);
            LocalDate date = LocalDate.parse(parts[3]);
            fruitBox = new FruitBox(fruitName, amount, date, false);
            switch (parts[0]) {
                case "r":
                    operation = new Return(OperationType.RETURN, fruitBox);
                    break;
                case "s":
                    operation = new Supply(OperationType.SUPPLY, fruitBox);
                    break;
                case "b":
                    operation = new Buy(OperationType.BUY, fruitBox);
                    break;
                default:
                    throw new RuntimeException("Unsuspected type of operation");
            }
            result.add(operation);
        }
        return result;
    }
}
