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
    private static final FileReadService FILE_READ_SERVICE;
    private static final FruitTransactionParser FRUIT_TRANSACTION_PARSER;
    private static final TransactionProcessor TRANSACTION_PROCESSOR;
    private static final ReportGenerator REPORT_GENERATOR;
    private static final FileWriteService FILE_WRITE_SERVICE;

    static {
        FILE_READ_SERVICE = new FileReadServiceImpl();
        FRUIT_TRANSACTION_PARSER = new FruitTransactionParserImpl();
        TRANSACTION_PROCESSOR = new TransactionProcessorImpl();
        REPORT_GENERATOR = new ReportGeneratorImpl();
        FILE_WRITE_SERVICE = new FileWriteServiceImpl();
    }

    public static void main(String[] args) {
        String dataFromFile =
                FILE_READ_SERVICE.readFromFile(Path.of("src/main/resources/input.csv"));
        List<FruitTransaction> transactions = FRUIT_TRANSACTION_PARSER.toTransactions(dataFromFile);
        TRANSACTION_PROCESSOR.process(transactions);
        String report = REPORT_GENERATOR.generate();
        FILE_WRITE_SERVICE.writeToFile(Path.of("src/main/resources/output.csv"), report);
    }
}
