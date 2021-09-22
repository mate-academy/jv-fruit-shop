package service;

import bd.Storage;
import model.FruitRecordDto;
import service.type.service.TypeHandler;

public class FruitShopServiceImpl implements FruitShopService {
    @Override
    public void transfer(OperationStrategy operationStrategy) {
        for (FruitRecordDto temp : Storage.storageFruitShop) {
            TypeHandler resultStrategy = operationStrategy.getHandler(temp.getType());
            Integer result = resultStrategy
                    .getType(temp.getAmount(), Storage.mapReport.get(temp.getFruit()));
            Storage.mapReport.put(temp.getFruit(), result);
        }
    }
}
