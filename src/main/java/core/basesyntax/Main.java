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
        FileService workWithFile = new FileServiceImpl();
        List<String> fruitsList = workWithFile.readFromFile(SOURCE_FILE);

        // Створюємо мапу стратегії
        Map<String, DataService> operationDataServiceMap = new HashMap<>();
        operationDataServiceMap.put(FruitTransaction.Operation.BALANCE.getCode(),
                new BalanceDataService(fruitDao));
        operationDataServiceMap.put(FruitTransaction.Operation.RETURN.getCode(),
                new ReturnDataService(fruitDao));
        operationDataServiceMap.put(FruitTransaction.Operation.SUPPLY.getCode(),
                new SupplyDataService(fruitDao));
        operationDataServiceMap.put(FruitTransaction.Operation.PURCHASE.getCode(),
                new PurchaseDataService(fruitDao));

        DataServiceStrategy dataServiceStrategy =
                new DataServiceStrategyImpl(operationDataServiceMap);

        // перетворюємо в ліст транзакцій
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        List<FruitTransaction> fruitTransactionList =
                fruitTransactionService.castToList(fruitsList);

        // і пішла обробка
        ProcessTransactions processFruits = new ProcessTransactions(dataServiceStrategy);
        processFruits.processFruitTransactionList(fruitTransactionList);

        //створюємо звіт по БД:
        ReportService reporter = new ReportServiceImpl(fruitDao);
        String report = reporter.create();

        //записуємо звіт в файл
        workWithFile.writeToFile(DESTINATION_FILE, report);

    }
}
