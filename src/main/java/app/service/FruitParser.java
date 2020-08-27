package app.service;

import app.model.SupplyFruit;
import java.util.List;

public interface FruitParser {
    SupplyFruit parse(List<String> data);
}
