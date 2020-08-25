package core.basesyntax;

import java.time.LocalDate;
import java.util.List;

public interface StoreOperations {
    void action(List<Fruit> fruitList, String name, LocalDate date, Integer quantity);
}
