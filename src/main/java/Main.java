import dao.CsvTransactionDao;
import dao.CsvTransactionDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataConverter;
import service.DataProcessor;
import service.ReportGenerator;
import service.impl.DataConverterImpl;
import service.impl.DataProcessorImpl;
import service.impl.ReportGeneratorImpl;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.handler.BalanceHandler;
import strategy.handler.OperationHandler;
import strategy.handler.PurchaseHandler;
import strategy.handler.ReturnHandler;
import strategy.handler.SupplyHandler;

public class Main {
    private static final String FOLDER_NAME = "statistic";
    private static final String TRANSACTION_FILE_NAME = "transactions.csv";
    private static final String REPORT_FILE_NAME = "report.csv";

    public static void main(String[] args) {
        CsvTransactionDao csvTransactionDao = new CsvTransactionDaoImpl();
        csvTransactionDao.createDaoFolder(FOLDER_NAME);
        csvTransactionDao.createFile(TRANSACTION_FILE_NAME, FOLDER_NAME);

        String dayTransactions = "type,fruit,quantity" + System.lineSeparator()
                + "b,banana,20" + System.lineSeparator()
                + "b,apple,100" + System.lineSeparator()
                + "s,banana,100" + System.lineSeparator()
                + "p,banana,13" + System.lineSeparator()
                + "r,apple,10" + System.lineSeparator()
                + "p,apple,20" + System.lineSeparator()
                + "p,banana,5" + System.lineSeparator()
                + "s,banana,50";

        csvTransactionDao.writeToFile(dayTransactions, TRANSACTION_FILE_NAME, FOLDER_NAME);

        List<String> stringOfTransactions = csvTransactionDao
                .readFromFile(TRANSACTION_FILE_NAME, FOLDER_NAME);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> fruitTransactions = dataConverter.convertData(stringOfTransactions);

        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceHandler());
        operationHandlerMap.put("s", new SupplyHandler());
        operationHandlerMap.put("p", new PurchaseHandler());
        operationHandlerMap.put("r", new ReturnHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        DataProcessor dataProcessor = new DataProcessorImpl(operationStrategy);
        Map<String, Integer> operationResult = dataProcessor.process(fruitTransactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.createReport(operationResult);

        csvTransactionDao.createFile(REPORT_FILE_NAME, FOLDER_NAME);

        csvTransactionDao.writeToFile(report, REPORT_FILE_NAME, FOLDER_NAME);

    }
}
