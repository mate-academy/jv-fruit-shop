package core.basesyntax;

import java.time.LocalDate;
import java.util.List;

public class DataParser {
    public FruitPackage mapToFruit(List<String> row) {
        FruitPackage fruitPackage = new FruitPackage(row.get(1),
                Integer.parseInt(row.get(2)), LocalDate.parse(row.get(3)));
        return fruitPackage;
    }
}
