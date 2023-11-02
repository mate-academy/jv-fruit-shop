package core.basesyntax.service;

import core.basesyntax.strategy.TypeStrategy;
import core.basesyntax.strategy.TypeStrategyImpl;
import core.basesyntax.strategy.type.BalanceTypeHandler;
import core.basesyntax.strategy.type.PurchaseTypeHandler;
import core.basesyntax.strategy.type.ReturnTypeHandler;
import core.basesyntax.strategy.type.SupplyTypeHandler;
import core.basesyntax.strategy.type.TypeHandlers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodStoreServiceImpl implements FoodStoreService {
    private final ParseDailyDataFromFileService parseDailyDataFromFileService
            = new ParseDailyDataFromFileServiceImpl();
    private Map<Character, TypeHandlers> typeHandlersMap = new HashMap<>() {
        {
            put('b', new BalanceTypeHandler());
            put('s', new SupplyTypeHandler());
            put('p', new PurchaseTypeHandler());
            put('r', new ReturnTypeHandler());
        }
    };
    private TypeStrategy typeStrategy = new TypeStrategyImpl(typeHandlersMap);
    private List<String> reportData = new ArrayList<>();
    private Map<String, Integer> data = new HashMap<>();

    @Override
    public List<String> createReport(List<String> dataFromFile) {
        for (String line : dataFromFile) {
            String currentFruitName = parseDailyDataFromFileService.getFruitName(line);
            int currentQuantity = parseDailyDataFromFileService.getQuantity(line);
            if (!data.containsKey(currentFruitName)) {
                data.put(currentFruitName, currentQuantity);
                continue;
            }
            int newValue = typeStrategy.get(parseDailyDataFromFileService.getType(line))
                    .operation(data.get(currentFruitName),currentQuantity);
            checkNegativeBalance(newValue);
            data.put(currentFruitName, newValue);
        }
        return mapToList(data);
    }

    private List<String> mapToList(Map<String, Integer> data) {
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            checkNegativeBalance(entry.getValue());
            reportData.add(entry.getKey() + ", " + entry.getValue());
        }
        return reportData;
    }

    private void checkNegativeBalance(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Balance less then 0! Current balance: "
                    + quantity);
        }
    }
}
