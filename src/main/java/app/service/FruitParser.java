package app.service;

import app.model.Fruit;
import java.util.List;

public interface FruitParser {
    Fruit parse(List<String> data);
}
