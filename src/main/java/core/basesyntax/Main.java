package core.basesyntax;

import dao.FruitDao;
import dao.impl.FruitDaoImpl;
import handler.OperationHandler;
import handler.impl.BalanceOperation;
import handler.impl.PurchaseOperation;
import handler.impl.ReturnOperation;
import handler.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import services.FileReaderService;
import services.FileWriterService;
import services.OperationProcessor;
import services.ParserService;
import services.ReportGenerator;
import services.impl.FileReaderServiceImpl;
import services.impl.FileWriterServiceImpl;
import services.impl.OperationProcessorImpl;
import services.impl.ParserServiceImpl;
import services.impl.ReportGeneratorImpl;
import strategy.OperationStrategy;
import strategy.impl.OperationStrategyImpl;

public class Main {
    private static final String INPUT_PATH_FILE = "src/main/java/files/transactions.csv";
    private static final String OUTPUT_PATH_FILE = "src/main/java/files/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> handlerOperationMap = new HashMap<>();
        handlerOperationMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceOperation(fruitDao));
        handlerOperationMap.put(
                FruitTransaction.Operation.SUPPLY, new SupplyOperation(fruitDao));
        handlerOperationMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(fruitDao));
        handlerOperationMap.put(
                FruitTransaction.Operation.RETURN, new ReturnOperation(fruitDao));

        FileReaderService reader = new FileReaderServiceImpl();
        List<String> transactions = reader.getFruitData(INPUT_PATH_FILE);
        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> dataTransactions = parserService.parse(transactions);
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerOperationMap);
        OperationProcessor processor = new OperationProcessorImpl(operationStrategy);
        processor.process(dataTransactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(fruitDao);
        String report = reportGenerator.report();
        FileWriterService writer = new FileWriterServiceImpl(reportGenerator);
        writer.writeToFile(OUTPUT_PATH_FILE, report);
    }
}
