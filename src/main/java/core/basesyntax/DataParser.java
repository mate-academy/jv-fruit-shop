package core.basesyntax;

import java.time.LocalDate;
import java.util.List;

public class DataParser {
    Fruit toReadFromSting(List<String> row) {
        Fruit fruit = new Fruit(row.get(1),
                Integer.parseInt(row.get(2)), LocalDate.parse(row.get(3)));
        return fruit;
    }
}
