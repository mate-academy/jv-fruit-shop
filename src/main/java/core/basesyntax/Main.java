package core.basesyntax;

import core.basesyntax.service.FileReader;
import core.basesyntax.serviceimpl.ExecuteOperations;
import core.basesyntax.serviceimpl.FileReaderCsv;
import core.basesyntax.serviceimpl.FruitTransaction;
import core.basesyntax.serviceimpl.FruitTransactionParserImpl;
import core.basesyntax.serviceimpl.ReportGenerator;
import core.basesyntax.serviceimpl.Writer;
import core.basesyntax.storage.Storage;
import java.util.List;

public class Main {
    private static final String FILE_PATH_EXAMPLE = "src/main/resources/example.csv";
    private static final String FILE_PATH_REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderCsv();
        FruitTransactionParserImpl csvFileHandler = new FruitTransactionParserImpl();
        ReportGenerator reportGenerator = new ReportGenerator();
        Writer writer = new Writer();
        ExecuteOperations executeOperations = new ExecuteOperations();

        List<String> strings = fileReader.read(FILE_PATH_EXAMPLE);
        List<FruitTransaction> parsed = csvFileHandler.parse(strings);

        executeOperations.separateFruitsAndValues(parsed);
        writer.writeInFile(FILE_PATH_REPORT,
                reportGenerator.generateReport(Storage.fruits));
    }
}
