package core.basesyntax;

import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FormatTransformerService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FormatTransformerServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.Strategy;
import java.util.List;

public class Main {
    private static final String REPORT_PATH = "src/main/resources/Report3.csv";
    private static final String SOURCE_PATH = "src/main/resources/Data.csv";

    public static void main(String[] args) {
        List<String> linesFromFile = new FileReaderServiceImpl().readFile(SOURCE_PATH);
        FormatTransformerService transformer = new FormatTransformerServiceImpl();
        List<FruitTransaction> fruitTransactions = transformer.formatData(linesFromFile);

        StorageImpl storageImpl = new StorageImpl();
        Strategy operationStrategy = new Strategy(storageImpl);

        FruitService analysisFile = new FruitServiceImpl(operationStrategy);
        analysisFile.process(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        CsvFileWriterService csvFileWriter = new FileWriterServiceImpl();
        List<String> report = reportService.createReport();
        csvFileWriter.writeFile(report, REPORT_PATH);
    }
}
