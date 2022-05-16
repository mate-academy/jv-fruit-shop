package mate.academy.service;

import java.util.List;
import mate.academy.model.Fruit;

public interface ParseService {
    List<Fruit> parseString(List<String> strings);
}
