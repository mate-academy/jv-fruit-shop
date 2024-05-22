package core.basesyntax.service;

import core.basesyntax.model.Operations;
import java.util.List;

public interface FruitsService {
    void createNewFruits(String fruitName, int quantity);

    int getOperatedCount(int oldFruitsQuantity, int newFruitsQuantity, Operations operation);

    void createFruitsFromList(List<String> fruitsDocumentation);
}
