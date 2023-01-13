import java.nio.file.Path;
import java.util.List;
import model.FruitTransaction;
import service.FileReadService;
import service.FileWriteService;
import service.FruitTransactionParser;
import service.ReportGenerator;
import service.TransactionProcessor;
import service.impl.FileReadServiceImpl;
import service.impl.FileWriteServiceImpl;
import service.impl.FruitTransactionParserImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.TransactionProcessorImpl;

public class Main {
    private static FileReadService fileReadService = new FileReadServiceImpl();
    private static FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
    private static TransactionProcessor transactionProcessor = new TransactionProcessorImpl();
    private static ReportGenerator reportGenerator = new ReportGeneratorImpl();
    private static FileWriteService fileWriteService = new FileWriteServiceImpl();

    Main() {
        fileReadService = new FileReadServiceImpl();
        fruitTransactionParser = new FruitTransactionParserImpl();
        transactionProcessor = new TransactionProcessorImpl();
        reportGenerator = new ReportGeneratorImpl();
        fileWriteService = new FileWriteServiceImpl();
    }

    public static void main(String[] args) {
        String dataFromFile = fileReadService.readFromFile(Path.of("src/main/resources/input.csv"));
        List<FruitTransaction> transactions = fruitTransactionParser.toTransactions(dataFromFile);
        transactionProcessor.process(transactions);
        String report = reportGenerator.generate();
        fileWriteService.writeToFile(Path.of("src/main/resources/output.csv"), report);
    }
}
