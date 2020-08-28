package app.service;

import app.model.SupplyFruitBatch;
import java.util.List;

public interface FruitParser {
    SupplyFruitBatch parse(List<String> data);
}
