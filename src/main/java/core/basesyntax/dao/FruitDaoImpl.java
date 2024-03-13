package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TypeOfFruit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private FruitStorage balance = new FruitStorage();

    @Override
    public void transferStartBalance(Map<TypeOfFruit, Integer> map,
                                     List<FruitTransaction> fruitInfoList) {
        balance.setBalanceMap(map);
        balance.setFruitInfoList(fruitInfoList);
    }

    @Override
    public void rebalanced(Map<TypeOfFruit, Integer> map) {
        balance.setBalanceMap(map);
    }

    @Override
    public Map<TypeOfFruit, Integer> getInfoFromBalance() {
        return balance.getBalanceMap();
    }

    @Override
    public List<FruitTransaction> getInfoFromPurchaseOperationFruit() {
        List<FruitTransaction> returnList = new ArrayList<>();
        for (FruitTransaction fruitInfo : balance.getFruitInfoList()) {
            if (fruitInfo.getOperation().equals(Operation.PURCHASE)) {
                returnList.add(fruitInfo);
            }
        }
        return returnList;
    }

    @Override
    public List<FruitTransaction> getInfoFromReturnOperationFruit() {
        List<FruitTransaction> returnList = new ArrayList<>();
        for (FruitTransaction fruitInfo : balance.getFruitInfoList()) {
            if (fruitInfo.getOperation().equals(Operation.RETURN)) {
                returnList.add(fruitInfo);
            }
        }
        return returnList;
    }

    @Override
    public List<FruitTransaction> getInfoFromSupplyOperationFruit() {
        List<FruitTransaction> returnList = new ArrayList<>();
        for (FruitTransaction fruitInfo : balance.getFruitInfoList()) {
            if (fruitInfo.getOperation().equals(Operation.SUPPLY)) {
                returnList.add(fruitInfo);
            }
        }
        return returnList;
    }
}
