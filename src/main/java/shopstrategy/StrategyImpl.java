package shopstrategy;

import java.util.Map;
import shopoperations.ListOfOperations;
import shopoperations.ShopBalanceOperation;

public class StrategyImpl implements Strategy {
    private final Map<ListOfOperations, ShopBalanceOperation> balanceOperationMap;

    public StrategyImpl(Map<ListOfOperations, ShopBalanceOperation> balanceOperationMap) {
        this.balanceOperationMap = balanceOperationMap;
    }

    @Override
    public ShopBalanceOperation get(ListOfOperations type) {
        return balanceOperationMap.get(type);
    }
}
