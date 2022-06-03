package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.BalanceService;
import core.basesyntax.services.BalanceServiceImpl;
import core.basesyntax.services.FruitService;
import core.basesyntax.services.FruitServiceImpl;
import core.basesyntax.services.ReadFromFileService;
import core.basesyntax.services.ReadFromFileServiceImpl;
import core.basesyntax.services.WriteToFileService;
import core.basesyntax.services.WriteToFileServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        FruitService fruitService = new FruitServiceImpl();
        BalanceService balanceService = new BalanceServiceImpl();;
        ReadFromFileService readFromFileService = new ReadFromFileServiceImpl();
        WriteToFileService writeToFileService = new WriteToFileServiceImpl();

        List<FruitTransaction> fruitTransactionList = fruitService
                .getListOfTransactions(readFromFileService.readDbFromFile("DB.csv"));
        fruitService.addUniqueFruitsToStorage(fruitTransactionList);
        balanceService.balance(fruitTransactionList);
        writeToFileService.putDbToFile(storageDao.get(), "REPORT.csv");
    }
}
