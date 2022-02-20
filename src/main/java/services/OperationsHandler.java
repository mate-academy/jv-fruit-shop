package services;

import model.FruitRecord;

public interface OperationsHandler {
    void apply(FruitDaoService daoService, FruitRecord fruitRecord);
}
