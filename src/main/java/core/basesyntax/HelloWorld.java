package core.basesyntax;

import dao.DaoFruit;
import dao.FruitImplemDao;
import db.Storage;
import implementation.FruitTransactionParserImpl;
import implementation.FruitTransactionServiceImpl;
import implementation.ReportServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import operations.BalanceOperation;
import operations.OperationHandler;
import operations.PurchaseOperation;
import operations.ReturnOperation;
import operations.SupplyOperation;
import service.FileReader;
import service.FileWriter;
import service.FruitParser;
import service.FruitService;
import service.ReportService;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import strategy.Strategy;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    private static final String INPUT_PATH_TOFILE = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH_TOFILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        DaoFruit fruitDao = new FruitImplemDao();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperation(fruitDao));
        operationHandlersMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperation(fruitDao));
        operationHandlersMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperation(fruitDao));
        operationHandlersMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperation(fruitDao));
        FileReader fileReader = new FileReaderImpl();

        List<String> inputStrings = fileReader.readFromFile(INPUT_PATH_TOFILE);

        FruitParser parser = new FruitTransactionParserImpl();
        List<FruitTransaction> fruitTransactions =
                parser.parse(inputStrings);

        Strategy strategy = new Strategy(operationHandlersMap);
        FruitService fruitService =
                new FruitTransactionServiceImpl(strategy);
        fruitService.process(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.writeReport(Storage.fruits);

        FileWriter writer = new FileWriterImpl();
        writer.writeToFile(report, OUTPUT_PATH_TOFILE);

    }
}
