package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitMapper {
    List<FruitTransaction> parseOperation(List<String> dataFromFile);
}
