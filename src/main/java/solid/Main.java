package solid;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import solid.model.FruitTransaction;
import solid.service.FruitTransactionParser;
import solid.service.ReportGenerator;
import solid.service.TransactionProcessor;
import solid.service.WriteFileService;
import solid.service.impl.FileReadServiceImpl;
import solid.service.impl.FruitTransactionParserImpl;
import solid.service.impl.ReportGeneratorImpl;
import solid.service.impl.TransactionProcessorImpl;
import solid.service.impl.WriteFileServiceImpl;

public class Main {
    private static final String FILE_WRITE_PATH =
            "src/main/resources/result.csv";
    private static final String FILE_READ_PATH =
            "src/main/resources/date.csv";
    private static final FileReadServiceImpl FILE_READ_SERVICE =
            new FileReadServiceImpl();
    private static final FruitTransactionParser FRUIT_TRANSACTION_PARSER =
            new FruitTransactionParserImpl();
    private static final TransactionProcessor TRANSACTION_PROCESSOR =
            new TransactionProcessorImpl();
    private static final ReportGenerator REPORT_GENERATOR =
            new ReportGeneratorImpl();
    private static final WriteFileService WRITE_FILE_SERVICE =
            new WriteFileServiceImpl();

    public static void main(String[] args) {
        File outputFile = new File(FILE_WRITE_PATH);
        String dataFromFile = FILE_READ_SERVICE.readFromFile(Path.of(FILE_READ_PATH));
        List<FruitTransaction> transactions = FRUIT_TRANSACTION_PARSER.toTransaction(dataFromFile);
        TRANSACTION_PROCESSOR.process(transactions);
        String report = REPORT_GENERATOR.generate();
        WRITE_FILE_SERVICE.writeToFile(outputFile.toPath(), report);
    }
}
