import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.List;
import model.FruitTransaction;
import service.FruitOperationTypeParser;
import service.FruitTransactionParser;
import service.Reader;
import service.ReportService;
import service.TransactionProcessor;
import service.Writer;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.FruitOperationTypeParserImpl;
import service.impl.FruitTransactionParserImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionProcessorImpl;

public class Main {
    private static final String FILE_NAME_INPUT_DATA = "src/main/resources/inputDateFile.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/file.csv";

    public static void main(String[] args) {
        Reader reader = new FileReaderImpl();
        List<String> data = reader.readFile(FILE_NAME_INPUT_DATA);

        FruitOperationTypeParser fruitOperationTypeParser = new FruitOperationTypeParserImpl();
        FruitTransactionParser fruitTransactionParser
                = new FruitTransactionParserImpl(fruitOperationTypeParser);
        List<FruitTransaction> fruits = fruitTransactionParser.parseTransaction(data);

        TransactionProcessor transactionProcessor = new TransactionProcessorImpl();
        transactionProcessor.processTransactions(fruits);

        FruitDao fruitDao = new FruitDaoImpl();
        ReportService reportService = new ReportServiceImpl(fruitDao);
        String content = reportService.createReport();

        Writer writer = new FileWriterImpl();
        writer.writeToFile(REPORT_FILE_NAME, content);
    }
}
