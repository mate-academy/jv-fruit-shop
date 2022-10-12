package core.basesyntax;

import java.util.List;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.fileservice.FileReaderService;
import core.basesyntax.fileservice.FileWriterService;
import core.basesyntax.fileservice.impl.FileReaderServiceImpl;
import core.basesyntax.fileservice.impl.FileWriterServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationProcessing;
import core.basesyntax.service.ReportCsvParser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.OperationProcessingImpl;
import core.basesyntax.service.impl.ReportCsvParserImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import static core.basesyntax.service.impl.OperationProcessingImpl.operationHandlerMap;

public class Main {
    private static final String READ_FROM_FILE = "src/main/resources/activities.csv";
    private static final String WRITE_TO_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> strings = fileReaderService.readFromFile(READ_FROM_FILE);
        ReportCsvParser reportCsvParser = new ReportCsvParserImpl();
        List<FruitTransaction> parse = reportCsvParser.parse(strings);
        OperationProcessor fruitService = new OperationProcessorImpl(fruitDao, operationStrategy);
        for (FruitTransaction transaction : parse) {
            fruitService.process(transaction);
        }
        ReportGenerator creator = new ReportGeneratorImpl(fruitDao);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(creator.generateReport(), WRITE_TO_FILE);
    }
}
