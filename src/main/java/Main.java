import java.util.List;
import model.FruitTransaction;
import service.WriterService;
import service.impl.FruitTransactionServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/daily_summary.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/reportFile.csv";

    public static void main(String[] args) {
        List<String> dailyData = new ReaderServiceImpl().readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitsTransactionData = new FruitTransactionServiceImpl()
                .getFruitTransactionData(dailyData);
        String report = new ReportServiceImpl().getReport(fruitsTransactionData);
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, REPORT_FILE_PATH);
    }
}
