package store.service.activities;

import java.util.List;

public interface ActionsAble {
    void storeBalance(List<String> balanceData);

    void doActions(List<String> listOfDb);

    Integer returnFruits(String subActions, String subNameOfFruit, int subCost);

    Integer buyFruits(String subActions, String subNameOfFruit, int subCost);

    Integer supplyFruits(String subActions, String subNameOfFruit, int subCost);

    int getCostOfFruits(String nameOfFruit);
}
