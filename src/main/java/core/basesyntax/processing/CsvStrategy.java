package core.basesyntax.processing;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface CsvStrategy<T extends Fruit> {
    boolean countFruit(T fruit);

    boolean chooseOperation(String[] operation);

    List<String[]> reportStrategy();
}
