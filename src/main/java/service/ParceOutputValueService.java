package service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ParceOutputValueService {
    StringBuilder outputString = new StringBuilder();
    String storageToString(List<Fruit> storage);
}
