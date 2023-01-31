package core.basesyntax.writer;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface Writer {
    void write(List<Fruit> fruits);
}
