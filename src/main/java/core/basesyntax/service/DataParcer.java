package core.basesyntax.service;

import core.basesyntax.fruit.Fruit;
import java.util.List;

public interface DataParcer {
    List<Fruit> getFruitsMoving(List<String> list);
}
