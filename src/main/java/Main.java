import OpareationHandler.*;
import Service.Impl.ParsingServiceImpl;
import Service.Impl.ReadingServiceImpl;
import Service.Impl.ReportServiceImpl;
import Service.Impl.WritingServiceImpl;
import Service.ParsinService;
import Service.ReadingService;
import Service.ReportService;
import Service.WritingService;
import dao.FruitDaoImpl;
import dao.FruitsDao;
import model.FruitTransaction;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_PATH = "src/main/java/fruitsInfo.csv";
    private static final String TO_FILE_PATH = "src/main/java/report.csv";
    private static final int START_INDEX = 1;

    public static void main(String[] args) {

        FruitsDao fruitsDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceHandler(fruitsDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyHandler(fruitsDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurcheseHandler(fruitsDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnHandler(fruitsDao));
        ReadingService readed = new ReadingServiceImpl();
        ParsinService parsed = new ParsingServiceImpl();
        List<String> list = readed.readFromFile(FROM_FILE_PATH);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        for (String line: list.subList(START_INDEX, list.size())) {
            FruitTransaction fruitTransaction = parsed.parse(line);
            OperationHandler operationHandler =  operationStrategy.get(fruitTransaction.getOperation());
            operationHandler.handle(fruitTransaction);
        }

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(fruitsDao.getAll());
        System.out.println(report);
        WritingService writingService = new WritingServiceImpl();
        writingService.writeToFile(report, TO_FILE_PATH);
    }
}
