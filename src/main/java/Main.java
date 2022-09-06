import dao.FruitDao;
import dao.impl.FruitDaoImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.TransactionExecutor;
import service.TransactionParser;
import service.impl.ReportServiceImpl;
import service.impl.TransactionExecutorImpl;
import service.impl.TransactionParserImpl;

public class Main {
    private static final String INPUT_CSV_PATH = "src/main/resources/input.csv";
    private static final String REPORT_CSV_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        TransactionExecutor transactionExecutor = new TransactionExecutorImpl();
        try {
            transactionParser.parse(Files.readAllLines(Path.of(INPUT_CSV_PATH)))
                    .forEach(transactionExecutor::execute);
            Files.write(Path.of(REPORT_CSV_PATH),
                    new ReportServiceImpl(fruitDao).createReport().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't read or write info.", e);
        }
    }
}
