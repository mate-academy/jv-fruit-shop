package service.impl;

import java.util.List;
import java.util.Map;
import model.Fruit;
import service.FruitService;
import service.Strategy;

public class FruitServiceImpl implements FruitService {
    private final Strategy strategy;

    public FruitServiceImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Map<Fruit, Integer> saveDataToDb(List<TransactionDto> data) {
        for (TransactionDto transactionDto : data) {
            Storage.reportMap.put(transactionDto.getFruit(),strategy
                    .getActivity(transactionDto.getOperationType())
                    .getFruitAmount(transactionDto));
        }
        return Storage.reportMap;
    }
}
