import java.util.List;
import model.FruitTransaction;
import service.FruitShopService;
import service.FruitTransactionParser;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import service.impl.FruitShopServiceImpl;
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
    private static FruitShopService fruitShopService = new FruitShopServiceImpl();
    private static ReportService reportService = new ReportServiceImpl();

    public static void main(String[] args) {
        List<String> storeActivitiesFromFile = readerService.readFromFile(inputFilePath);
        List<FruitTransaction> fruitTransactions = fruitTransactionParser
                .parseFruitTransaction(storeActivitiesFromFile);
        fruitShopService.processOfOperations(fruitTransactions);
        String reportStringForWriting = reportService.getReportStringForWriting();
        writerService.writeToFile(reportStringForWriting, finalReportFilePath);
    }
}
