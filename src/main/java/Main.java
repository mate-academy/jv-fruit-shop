import db.FileReader;
import db.FileReaderImpl;
import db.FileWriter;
import db.FileWriterImpl;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitService;
import service.FruitServiceImpl;
import service.ReportService;
import service.ReportServiceImpl;
import service.TransactionMapperService;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.activities.BalanceHandler;
import strategy.activities.OperationHandler;
import strategy.activities.PurchaseHandler;
import strategy.activities.ReturnHandler;
import strategy.activities.SupplyHandler;

public class Main {
    private static final String filePath = "src/main/resources/file.csv"; // data from file
    private static final FileReader readFile = new FileReaderImpl();
    private static final FileWriter fileWriter = new FileWriterImpl();
    private static final ReportService reportService = new ReportServiceImpl();

    public static void main(String[] args) {
        // read data
        String transactions = readFile.read(filePath);

        // convert data to FruitTransaction
        List<FruitTransaction> convertedData =
                new TransactionMapperService().stringToFruitTransaction(transactions);

        // process
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
                FruitTransaction.Operation.RETURN, new ReturnHandler()
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        Map<String, Integer> calculatedData = fruitService.processData(convertedData);

        // create report
        String reportFile = reportService.generateReport(calculatedData);

        // write report to file
        fileWriter.writeToFile(reportFile);
    }
}
