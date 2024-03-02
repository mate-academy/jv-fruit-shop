package core.basesyntax;

import core.basesyntax.dao.Dao;
import core.basesyntax.dao.DaoImpl;
import core.basesyntax.service.Convert;
import core.basesyntax.service.ConvertImpl;
import core.basesyntax.service.ReadData;
import core.basesyntax.service.ReadDataImpl;
import core.basesyntax.service.StartingBalance;
import core.basesyntax.service.StartingBalanceImpl;
import core.basesyntax.service.Writer;
import core.basesyntax.service.WriterImpl;
import core.basesyntax.service.strategy.Activities;
import core.basesyntax.service.strategy.Purchase;
import core.basesyntax.service.strategy.Return;
import core.basesyntax.service.strategy.Supply;

public class Main {
    private static final Activities sup = new Supply();
    private static final Activities ret = new Return();
    private static final Activities pur = new Purchase();
    private static final ReadData readData = new ReadDataImpl();
    private static final Convert convert = new ConvertImpl();
    private static final Writer writer = new WriterImpl();
    private static final Dao transferDao = new DaoImpl();
    private static final StartingBalance startingBalance = new StartingBalanceImpl();

    public static void main(String[] args) {
        Main.start();
    }

    private static void start() {
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
