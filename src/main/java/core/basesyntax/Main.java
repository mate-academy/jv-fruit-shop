package core.basesyntax;

import core.basesyntax.csv.reader.ReadFromFile;
import core.basesyntax.csv.reader.WriteToFile;
import core.basesyntax.csv.reader.impl.ReadFromFileImpl;
import core.basesyntax.csv.reader.impl.WriteToFileImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitParser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.FruitParserImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.storage.Storage;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final String PATH_FROM = "src/main/resources/resources.csv";
    private static final String PATH_TO = "src/main/resources/result.csv";
    private static final ReadFromFile readFromFile = new ReadFromFileImpl();
    private static final FruitParser fruitParser = new FruitParserImpl();
    private static final TransactionProcessor transactionProcessor = new TransactionProcessorImpl();
    private static final ReportGenerator reportGenerator = new ReportGeneratorImpl();
    private static final WriteToFile writeToFile = new WriteToFileImpl();

    public static void main(String[] args) {
        List<FruitTransaction> transaction = fruitParser
                .createTransaction(readFromFile.readFile(Path.of(PATH_FROM)));
        transactionProcessor.doTransaction(transaction);
        String makeReport = reportGenerator.makeReport(Storage.fruits);
        writeToFile.writeFile(Path.of(PATH_TO), makeReport);
    }
}
