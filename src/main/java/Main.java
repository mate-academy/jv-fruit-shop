import dao.FruitTransactionDao;
import dao.FruitTransactionDaoImpl;
import java.util.HashMap;
import java.util.List;
import model.FruitTransaction;
import service.FruitTransactionParser;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import service.impl.FruitTransactionParserImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;

public class Main {
    private static String inputFilePath = "src/main/resources/input_report.csv";
    private static String finalReportFilePath = "src/main/resources";
    private static ReaderService readerService = new ReaderServiceImpl();
    private static WriterService writerService = new WriterServiceImpl();
    private static FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
    private static ReportService reportService = new ReportServiceImpl();
    private static FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();

    public static void main(String[] args) {
        List<String> storeActivitiesFromFile = readerService.readFromFile(inputFilePath);
        List<FruitTransaction> fruitTransactions = fruitTransactionParser
                .parseFruitTransaction(storeActivitiesFromFile);
        fruitTransactionDao.saveAllTransactionToDB(fruitTransactions);
        HashMap<String, Integer> currentBalanceReportToStoreDB = reportService
                .createReportToStoreDB();
        fruitTransactionDao.saveCurrentBalanceByFruitToDB(currentBalanceReportToStoreDB);
        writerService.writeToFile(finalReportFilePath);
    }
}
