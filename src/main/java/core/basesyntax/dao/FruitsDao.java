package core.basesyntax.dao;

import java.util.List;

public interface FruitsDao {
    void addFruitsStorage(String stringListFruits);

    List<String> getAllFruits();
}
