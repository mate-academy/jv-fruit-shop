package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileParseService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.TransactionsActivitiesService;
import core.basesyntax.service.cv.CVcreation;
import core.basesyntax.service.cv.CVcreationImpl;
import core.basesyntax.service.impl.FileParseServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.TransactionsActivitiesServiceImpl;
import core.basesyntax.strategy.OperationOption;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operationhandlers.BalanceOperationHandler;
import core.basesyntax.strategy.operationhandlers.PurchaseOperation;
import core.basesyntax.strategy.operationhandlers.ReturnOperation;
import core.basesyntax.strategy.operationhandlers.SupplyOperation;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        FruitDao fruitDao = new FruitDaoImpl();

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        FileParseService fileParseService = new FileParseServiceImpl();

        CVcreation cvCreationService = new CVcreationImpl(fruitDao);

        // Ініціалізація стратегії операцій
        OperationOption operationOption = new OperationStrategy(Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(fruitDao),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(fruitDao),
                FruitTransaction.Operation.RETURN, new ReturnOperation(fruitDao),
                FruitTransaction.Operation.SUPPLY, new SupplyOperation(fruitDao)
        ));

        TransactionsActivitiesService transactionsActivitiesService =
                new TransactionsActivitiesServiceImpl(operationOption);

        List<String> dataFromFile = fileReaderService
                .readFromFile("src/main/resources/input_file.csv");

        List<FruitTransaction> transactions = fileParseService
                .parseDataFromCV(dataFromFile);

        transactionsActivitiesService.activityOfTransaction(transactions);

        String cvContent = cvCreationService.createCV();

        fileWriterService
        .writeToFile(cvContent, "src/main/resources/output_file.csv");
    }
}
