package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.FruitTransactionMapper;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.CsvDataParser;
import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvReportGenerator;
import core.basesyntax.service.impl.CsvReportWriter;
import core.basesyntax.service.impl.OperationProcessorImpl;
import core.basesyntax.strategy.HandlerStrategy;
import java.util.List;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/Input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/Output.csv";

    public static void main(String[] args) {
        final StorageDao storageDao = new StorageDaoImpl();

        HandlerStrategy strategy = new HandlerStrategy(storageDao);
        strategy.fillStrategyMap();

        DataReader dataReader = new CsvReader();
        List<String> readData = dataReader.read(INPUT_FILE);

        FruitTransactionMapper mapper = new CsvDataParser();
        List<FruitTransaction> transactionList = mapper.map(readData);

        TransactionProcessor transactionProcessor = new OperationProcessorImpl(strategy);
        transactionProcessor.process(transactionList);

        ReportGenerator reportGenerator = new CsvReportGenerator(storageDao);
        String report = reportGenerator.generateReport();

        DataWriter writer = new CsvReportWriter();
        writer.write(report, OUTPUT_FILE);
    }
}
