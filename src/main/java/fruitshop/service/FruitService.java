package fruitshop.service;

import fruitshop.model.FruitTransaction;
import java.util.List;

public interface FruitService {
    void processFruits(List<FruitTransaction> dataLinesObj);
}
