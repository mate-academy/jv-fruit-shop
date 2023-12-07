package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CV.CVcreation;
import core.basesyntax.service.CV.CVcreationImpl;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FileParseService;
import core.basesyntax.service.TransactionsActivitiesService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FileParseServiceImpl;
import core.basesyntax.service.impl.TransactionsActivitiesServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationOption;
import core.basesyntax.strategy.operationhandlers.BalanceOperationHandler;
import core.basesyntax.strategy.operationhandlers.PurchaseOperation;
import core.basesyntax.strategy.operationhandlers.ReturnOperation;
import core.basesyntax.strategy.operationhandlers.SupplyOperation;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        // Ініціалізація DAO
        FruitDao fruitDao = new FruitDaoImpl();

        // Ініціалізація сервісів для роботи з файлами
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        FileParseService fileParseService = new FileParseServiceImpl();

        // Ініціалізація сервісу для роботи з CV
        CVcreation cvCreationService = new CVcreationImpl(fruitDao);

        // Ініціалізація стратегії операцій
        OperationOption operationOption = new OperationStrategy(Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(fruitDao),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(fruitDao),
                FruitTransaction.Operation.RETURN, new ReturnOperation(fruitDao),
                FruitTransaction.Operation.SUPPLY, new SupplyOperation(fruitDao)
        ));

        // Ініціалізація сервісу для виконання транзакцій
        TransactionsActivitiesService transactionsActivitiesService =
                new TransactionsActivitiesServiceImpl(operationOption);

        // Читання даних з файлу
        List<String> dataFromFile = fileReaderService.readFromFile("src/main/resources/input_file.csv");

        // Розбір даних з файлу до транзакцій
        List<FruitTransaction> transactions = fileParseService.parseDataFromCV(dataFromFile);

        // Виконання транзакцій
        transactionsActivitiesService.ActivityOfTransaction(transactions);

        // Створення CV
        String cvContent = cvCreationService.createCV();

        // Запис CV у файл
        fileWriterService.writeToFile(cvContent, "src/main/resources/output_file.csv");
    }
}
