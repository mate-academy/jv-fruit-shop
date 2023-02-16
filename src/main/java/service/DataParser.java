package service;

import java.util.List;
import model.FruitTransaction;

public interface DataParser {
    List<FruitTransaction> splitToCategories(List<String> dataFromFile);
}
