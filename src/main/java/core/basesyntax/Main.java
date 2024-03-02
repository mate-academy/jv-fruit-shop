package core.basesyntax;

import core.basesyntax.dao.Dao;
import core.basesyntax.dao.DaoImpl;
import core.basesyntax.service.*;
import core.basesyntax.service.strategy.Activities;
import core.basesyntax.service.strategy.Purchase;
import core.basesyntax.service.strategy.Return;
import core.basesyntax.service.strategy.Supply;


public class Main {

    public static void main(String[] args) {
       Main.start();
    }

    private static void start() {
        ReadData readData = new ReadDataImpl();
        Convert convert = new ConvertImpl();
        Writer writer = new WriterImpl();
         Dao transferDao = new DaoImpl();
         StartingBalance startingBalance = new StartingBalanceImpl();
         Activities sup = new Supply();
         Activities ret = new Return();
         Activities pur = new Purchase();

        transferDao.transferToAllFruit(convert.convertToJavaObject(readData.readDataFromFile()));
        transferDao.transferToBalance(startingBalance.getStartingBalance(transferDao
                .getInfoFromAllFruit()));
        transferDao.transferToBalance(sup.calculateBalanceAfterActivities(transferDao
                .getInfoFromAllFruit(), transferDao.getInfoFromBalance()));
        transferDao.transferToBalance(ret.calculateBalanceAfterActivities(transferDao
                .getInfoFromAllFruit(), transferDao.getInfoFromBalance()));
        transferDao.transferToBalance(pur.calculateBalanceAfterActivities(transferDao
                .getInfoFromAllFruit(), transferDao.getInfoFromBalance()));
        writer.writeRepo(transferDao.getInfoFromBalance());
    }
}
