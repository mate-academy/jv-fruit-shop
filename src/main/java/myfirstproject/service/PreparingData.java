package myfirstproject.service;

import java.util.Map;
import myfirstproject.model.Fruit;

public interface PreparingData {
    String prepare(StringBuilder data, Map<Fruit, Integer> mapToWrite);
}
