package core.basesyntax;

import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import model.FruitTransaction;
import operation.BalanceOperationHandler;
import operation.OperationHandler;
import operation.PurchaseOperationHandler;
import operation.ReturnOperationHandler;
import operation.SupplyOperationHandler;
import service.FileReader;
import service.FileWriter;
import service.FruitTransactionService;
import service.ReportService;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.FruitTransactionServiceImpl;
import service.impl.Parser;
import service.impl.ReportServiceImpl;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    private static final String OUTPUT_PATH = "src/main/resources/output.csv";
    private static final String INPUT_PATH = "src/main/resources/input.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler(storageDao));
        operationHandlerMap.put("p", new PurchaseOperationHandler(storageDao));
        operationHandlerMap.put("r", new ReturnOperationHandler(storageDao));
        operationHandlerMap.put("s", new SupplyOperationHandler(storageDao));

        FileReader fileReader = new FileReaderImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(operationStrategy);
        Function<List<String>, List<FruitTransaction>> parser = new Parser();
        fruitTransactionService.transfer(parser.apply(fileReader.read(INPUT_PATH)));
        ReportService reportService = new ReportServiceImpl(storageDao);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(OUTPUT_PATH, reportService.report());
    }
}
