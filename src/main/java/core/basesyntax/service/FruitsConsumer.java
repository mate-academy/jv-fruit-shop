package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.function.Consumer;
import java.util.List;

public interface FruitsConsumer extends Consumer<List<Fruit>> {
}
