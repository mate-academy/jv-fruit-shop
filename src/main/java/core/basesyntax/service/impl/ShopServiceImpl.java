package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.ResultData;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ShopService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<ResultData> process(List<FruitTransaction> transactions) {
        Map<String, Integer> resultDataMap = new HashMap<>();
        for (FruitTransaction transaction : transactions) {
            ResultData resultData = operationStrategy.get(
                    transaction.getOperation()
            ).handle(transaction);
            if (resultDataMap.containsKey(resultData.getFruitName())) {
                resultDataMap.compute(
                        resultData.getFruitName(),
                        (k, actualQuantity) -> actualQuantity
                                + resultData.getQuantity()
                );
            } else {
                resultDataMap.put(resultData.getFruitName(), resultData.getQuantity());
            }
        }
        List<ResultData> resultDataList = new ArrayList<>();
        for (Map.Entry<String, Integer> resultDataEntry : resultDataMap.entrySet()) {
            resultDataList.add(new ResultData(
                    resultDataEntry.getKey(),
                    resultDataEntry.getValue()
            ));
        }
        return resultDataList;
    }
}
