package core.basesyntax;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.io.File.separator;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src"
            + separator + "main"
            + separator + "resources"
            + separator + "InputFile.csv";
    private static final String PATH_TO_REPORT_FILE = "src"
            + separator + "main"
            + separator + "resources"
            + separator + "ReportFile.csv";
    private static Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
    private static List<String> lines;

    public static void main(String[] args) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        FileReadingService fileReadingService = new FileReadingServiceImpl();
        lines = fileReadingService.readFromFile(PATH_TO_INPUT_FILE);
        handlerMap.put(FruitTransaction.Operation.BALANCE, new AddOperation(fruitShopDao));
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new AddOperation(fruitShopDao));
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new SubtractOperation(fruitShopDao));
        handlerMap.put(FruitTransaction.Operation.RETURN, new AddOperation(fruitShopDao));
        ParsingService parsingService = new ParsingServiceImpl();
        TransactionService transactionService =
                new TransactionServiceImpl(new OperationStrategyImpl(handlerMap));
        transactionService.process(parsingService.getFruitTransactions(lines));
        ReportCreation reportCreation = new ReportCreationImpl(fruitShopDao);
        FileWritingServiceImpl writingService = new FileWritingServiceImpl();
        writingService.writeToFile(PATH_TO_REPORT_FILE, reportCreation.create());
    }
}
