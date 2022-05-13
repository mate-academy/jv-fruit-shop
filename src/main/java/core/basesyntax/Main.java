package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.service.OperationStrategyService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.FruitTransactionProcessorImpl;
import core.basesyntax.service.impl.OperationStrategyServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import java.util.List;

public class Main {
    private static final String FROM_FILE = "src/main/resources/input.csv";
    private static final String TO_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReader readService = new FileReaderImpl();
        List<String> readFile = readService.read(FROM_FILE);
        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
        List<FruitTransaction> infoFromFile = fruitTransactionParser.parse(readFile);
        StorageDao storageDao = new StorageDaoImpl();
        OperationStrategyService operationStrategyService = new OperationStrategyServiceImpl();
        FruitTransactionProcessor fruitTransactionProcessor = 
                new FruitTransactionProcessorImpl(operationStrategyService);
        fruitTransactionProcessor.process(infoFromFile);
        ReportCreator reportCreator = new ReportCreatorImpl(storageDao);
        String reportedInformation = reportCreator.createReport();
        new FileWriterImpl().write(reportedInformation, TO_FILE);
    }
}
