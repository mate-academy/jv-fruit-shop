package myfirstproject.strategy;

import myfirstproject.dao.DataBaseDao;
import myfirstproject.dao.impl.DataBaseDaoImpl;
import myfirstproject.model.Fruit;

public class Operation {
    private final DataBaseDao dataBaseDao = new DataBaseDaoImpl();

    public void changeValue(String type, Fruit fruit, int number) {
        switch (type) {
            case "b":
                new BalanceOperation(dataBaseDao, fruit, number);
                break;
            case "p":
                new PurchaseOperation(dataBaseDao, fruit, number);
                break;
            case "r":
                new ReturnOperation(dataBaseDao, fruit, number);
                break;
            case "s":
                new SupplyOperation(dataBaseDao, fruit, number);
                break;
            default:
        }
    }
}
