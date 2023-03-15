package core.basesyntax;

import core.basesyntax.database.StorageOfFruits;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculatorService;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CalculatorServiceImpl;
import core.basesyntax.service.impl.CreateReportServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationImpl;
import core.basesyntax.strategy.impl.ChooseStrategyHandlerImpl;
import core.basesyntax.strategy.impl.PurchaseOperationImpl;
import core.basesyntax.strategy.impl.ReturnOperationImpl;
import core.basesyntax.strategy.impl.SupplyOperationImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.txt";
    private static final String OUTPUT_FILE = "src/main/resources/output.txt";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> mapOfOperations = new HashMap<>();
        mapOfOperations.put(FruitTransaction.Operation.BALANCE, new BalanceOperationImpl());
        mapOfOperations.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationImpl());
        mapOfOperations.put(FruitTransaction.Operation.RETURN, new ReturnOperationImpl());
        mapOfOperations.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationImpl());
        ReaderServiceImpl readFromFile = new ReaderServiceImpl();
        List<String> list = readFromFile.getListOfDataFromFile(INPUT_FILE);
        ParserService cft = new ParserServiceImpl();
        CalculatorService calculatorService = new CalculatorServiceImpl(
                new ChooseStrategyHandlerImpl(mapOfOperations));
        calculatorService.calculate(cft.parse(list));
        CreateReportService createReportService = new CreateReportServiceImpl();
        String resultToCsv = createReportService.parse(StorageOfFruits.fruitStorage);
        WriterService writeToFile = new WriterServiceImpl();
        writeToFile.write(resultToCsv, OUTPUT_FILE);

    }
}
