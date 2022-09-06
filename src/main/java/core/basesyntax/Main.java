package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FruitReportService;
import core.basesyntax.services.FruitReportServiceImpl;
import core.basesyntax.services.FruitService;
import core.basesyntax.services.FruitServiceImpl;
import core.basesyntax.services.ReadService;
import core.basesyntax.services.ReadServiceImpl;
import core.basesyntax.services.WriteService;
import core.basesyntax.services.WriteServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ReadService readService = new ReadServiceImpl();
        FruitService fruitService = new FruitServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        FruitReportService fruitReportService = new FruitReportServiceImpl();
        WriteService writeService = new WriteServiceImpl();

        List<String> dataList = readService.readFile("src/main/sf.txt");
        List<FruitTransaction> fruitTransactionList = fruitService.getTransaction(dataList);
        for (FruitTransaction fruitTransaction: fruitTransactionList) {
            operationStrategy.apply(fruitTransaction);
        }
        Map<String, Integer> fruitInStorage = fruitStorageDao.getDataFromStorage();
        String report = fruitReportService.createReport(fruitInStorage);
        writeService.writeFile("src/main/report.txt", report);
    }
}
