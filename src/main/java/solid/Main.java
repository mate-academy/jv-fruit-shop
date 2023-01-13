package solid;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import solid.model.FruitTransaction;
import solid.model.FruitTransactionParser;
import solid.model.FruitTransactionParserImpl;
import solid.model.TransactionProcessor;
import solid.service.ReportGenerator;
import solid.service.WriteFileService;
import solid.service.impl.FileReadServiceImpl;
import solid.service.impl.ReportGeneratorImpl;
import solid.service.impl.TransactionProcessorImpl;
import solid.service.impl.WriteFileServiceImpl;

public class Main {
    private static final FileReadServiceImpl fileReadService =
            new FileReadServiceImpl();
    private static final FruitTransactionParser fruitTransactionParser =
            new FruitTransactionParserImpl();
    private static final TransactionProcessor transactionProcessor =
            new TransactionProcessorImpl();
    private static final ReportGenerator reportGenerator =
            new ReportGeneratorImpl();
    private static final WriteFileService writeFileService =
            new WriteFileServiceImpl();

    public static void main(String[] args) {
        String fileWritePath = "src/main/resources/result.csv";
        File outputFile = new File(fileWritePath);
        String fileReadPath = "src/main/resources/date.csv";
        String dataFromFile = fileReadService.readFromFile(Path.of(fileReadPath));
        List<FruitTransaction> transactions = fruitTransactionParser.toTransaction(dataFromFile);
        transactionProcessor.process(transactions);
        String report = reportGenerator.generate();
        writeFileService.writeToFile(outputFile.toPath(), report);
    }
}
