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
import core.basesyntax.services.ReportService;
import core.basesyntax.services.ReportServiceImpl;
import core.basesyntax.services.WriteToFileService;
import core.basesyntax.services.WriteToFileServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        FruitService fruitService = new FruitServiceImpl();
        BalanceService balanceService = new BalanceServiceImpl();
        ReadFromFileService readFromFileService = new ReadFromFileServiceImpl();
        WriteToFileService writeToFileService = new WriteToFileServiceImpl();
        ReportService reportService = new ReportServiceImpl();

        List<FruitTransaction> fruitTransactionList = fruitService
                .getListOfTransactions(readFromFileService.readFile("DB.csv"));
        fruitService.addUniqueFruitsToStorage(fruitTransactionList);
        balanceService.balance(fruitTransactionList);
        writeToFileService.writeToFile(reportService
                .createReport(storageDao.get()), "REPORT.csv");
    }
}
