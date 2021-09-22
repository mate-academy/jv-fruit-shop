package service.impl;

import java.util.List;
import java.util.Map;
import model.Fruit;
import service.FileService;
import service.Strategy;

public class FileServiceImpl implements FileService {
    private final Strategy strategy;

    public FileServiceImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Map<Fruit, Integer> saveDataToDb(List<TransactionDto> data) {
        for (TransactionDto transactionDto : data) {
            Storage.reportMap.put(transactionDto.getFruit(),strategy
                    .getActivity(transactionDto.getOperationType())
                    .getFruitAmount(transactionDto,Storage.reportMap));
        }
        return Storage.reportMap;
    }
}
