package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitParser;
import core.basesyntax.service.ReadFromFile;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.WriteToFile;
import core.basesyntax.service.impl.FruitParserImpl;
import core.basesyntax.service.impl.ReadFromFileImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
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
        List<FruitTransaction> transactions = fruitParser
                .parseData(readFromFile.readFile(Path.of(PATH_FROM)));
        transactionProcessor.doTransaction(transactions);
        String report = reportGenerator.makeReport(Storage.FRUITS_MAP);
        writeToFile.writeFile(Path.of(PATH_TO), report);
    }
}
