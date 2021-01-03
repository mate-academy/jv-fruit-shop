package store.service.activities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import store.service.activities.actions.BuyFruits;
import store.service.activities.actions.ReturnFruits;
import store.service.activities.actions.SupplyFruits;

public class ActionsOfFruits implements ActionsAble {
    private static final String BALANCE = "b";
    private static final String REMNANT = "r";
    private static final String BUY = "p";
    private static final String SUPPLY = "s";
    private static final String COMA = ",";
    private Map<String, Integer> resultData;

    public ActionsOfFruits() {
        resultData = new HashMap<>();
    }

    @Override
    public void storeBalance(List<String> balanceData) {
        for (int i = 0; i < balanceData.size(); i++) {
            String subActions = balanceData.get(i)
                    .substring(0, balanceData.get(i).indexOf(COMA));
            String subNameOfFruit = balanceData.get(i)
                    .substring(balanceData.get(i).indexOf(COMA) + 1,
                            balanceData.get(i).lastIndexOf(COMA));
            int subCost = Integer.parseInt(balanceData.get(i)
                    .substring(balanceData.get(i).lastIndexOf(COMA) + 1));
            if (subActions.equals(BALANCE)) {
                resultData.put(subNameOfFruit, subCost);
            }
        }
    }

    @Override
    public void doActions(List<String> listOfDb) {
        for (int i = 0; i < listOfDb.size(); i++) {
            String subActions = listOfDb.get(i)
                    .substring(0, listOfDb.get(i).indexOf(COMA));
            String subNameOfFruit = listOfDb.get(i)
                    .substring(listOfDb.get(i).indexOf(COMA) + 1,
                            listOfDb.get(i).lastIndexOf(COMA));
            int subCost = Integer.parseInt(listOfDb.get(i)
                    .substring(listOfDb.get(i).lastIndexOf(COMA) + 1));

            returnFruits(subActions, subNameOfFruit, subCost);
            buyFruits(subActions, subNameOfFruit, subCost);
            supplyFruits(subActions, subNameOfFruit, subCost);
        }
    }

    @Override
    public Integer returnFruits(String subActions, String subNameOfFruit, int subCost) {
        if (subActions.equals(REMNANT)) {
            int newCost = new ReturnFruits().apply(resultData.get(subNameOfFruit), subCost);
            if (resultData.containsKey(subNameOfFruit)) {
                resultData.put(subNameOfFruit, newCost);
                return resultData.get(subNameOfFruit);
            }
        }
        return 0;
    }

    @Override
    public Integer buyFruits(String subActions, String subNameOfFruit, int subCost) {
        if (subActions.equals(BUY)) {
            int newCost = new BuyFruits().apply(resultData.get(subNameOfFruit), subCost);
            if (resultData.containsKey(subNameOfFruit)) {
                resultData.put(subNameOfFruit, newCost);
                return resultData.get(subNameOfFruit);
            }
        }
        return 0;
    }

    @Override
    public Integer supplyFruits(String subActions, String subNameOfFruit, int subCost) {
        if (subActions.equals(SUPPLY)) {
            int newCost = new SupplyFruits().apply(resultData.get(subNameOfFruit), subCost);
            if (resultData.containsKey(subNameOfFruit)) {
                resultData.put(subNameOfFruit, newCost);
                return resultData.get(subNameOfFruit);
            }
        }
        return 0;
    }

    @Override
    public int getCostOfFruits(String nameOfFruit) {
        return resultData.get(nameOfFruit);
    }

    public Map<String, Integer> getResultData() {
        return resultData;
    }
}
