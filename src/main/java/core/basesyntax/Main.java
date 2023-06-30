package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.dataservice.BalanceDataService;
import core.basesyntax.service.dataservice.DataService;
import core.basesyntax.service.dataservice.PurchaseDataService;
import core.basesyntax.service.dataservice.ReturnDataService;
import core.basesyntax.service.dataservice.SupplyDataService;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.DataServiceStrategy;
import core.basesyntax.strategy.DataServiceStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE = "src/main/resources/fruits_database.csv";
    private static final String DESTINATION_FILE = "src/main/resources/fruits_report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();

        //Читаємо з файлу
        FileService fileService = new FileServiceImpl();
        List<String> sourceFileContent = fileService.readFromFile(SOURCE_FILE);

        // Створюємо мапу стратегії
        Map<FruitTransaction.Operation, DataService> operationDataServiceMap = new HashMap<>();
        operationDataServiceMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceDataService(fruitDao));
        operationDataServiceMap.put(FruitTransaction.Operation.RETURN,
                new ReturnDataService(fruitDao));
        operationDataServiceMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyDataService(fruitDao));
        operationDataServiceMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseDataService(fruitDao));

        DataServiceStrategy dataServiceStrategy =
                new DataServiceStrategyImpl(operationDataServiceMap);

        // перетворюємо в ліст транзакцій
        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(dataServiceStrategy);
        List<FruitTransaction> fruitTransactionList =
                fruitTransactionService.parseTransactions(sourceFileContent);
        // і пішла обробка
        fruitTransactionService.processTransactions(fruitTransactionList);

        //створюємо звіт по БД:
        ReportService reportService = new ReportServiceImpl(fruitDao);
        String report = reportService.create();

        //записуємо звіт в файл
        fileService.writeToFile(DESTINATION_FILE, report);

    }
}
