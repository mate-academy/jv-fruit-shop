package core.basesyntax.dao;

import java.util.List;

//Data access object
public interface RemnantsDao {

    void addFruitRemnant(String fruitName, Long fruitRemnant);

    Long getFruitRemnant(String fruitName);

    void updateFruitRemnant(String fruitName, Long newRemnant);

    boolean fruitIsPresentInStorage(String fruitName);

    List<String> getRemnantsReportList();
}
