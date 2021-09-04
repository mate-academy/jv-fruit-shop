package core.basesyntax;

import java.util.List;

public class FileFruitsValidation {
    private static final String CSV_SEPARATOR = ",";

    void validator(String readLine, List<FruitListOperation> operations) {
        try {

            String[] strings = readLine.split(CSV_SEPARATOR);
            String operation = strings[0];
            String fruitName = strings[1];
            int quantity = Integer.parseInt(strings[2]);
            if (quantity > 0) {
                operations.add(new FruitListOperation(operation, new Fruit(fruitName, quantity)));
            } else {
                throw new RuntimeException("No correct date");
            }
        } catch (Exception e) {
            throw new RuntimeException("File no correct", e);
        }
    }
}
