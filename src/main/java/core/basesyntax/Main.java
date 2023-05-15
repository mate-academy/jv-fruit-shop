package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitParserService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.FruitParserServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;

public class Main {
    private static final String INPUT_SOURCE_PATH = "src/main/resources/Information.csv";
    private static final String REPORT_SOURCE_PATH = "src/main/resources/report.csv";
    private static final CsvFileReaderService readerService = new CsvFileReaderServiceImpl();
    private static final CsvFileWriterService writerService = new CsvFileWriterServiceImpl();
    private static final FruitParserService parser = new FruitParserServiceImpl();
    private static final FruitService fruitService = new FruitServiceImpl();

    public static void main(String[] args) {
        List<String> listFromCsv = readerService.readLineFromFile(INPUT_SOURCE_PATH);
        List<FruitTransaction> fruits = parser.parserFruitTransaction(listFromCsv);
        OperationStrategy operationStrategies = new OperationStrategyImpl();
        fruitService.calculateShoppingCart(fruits,operationStrategies);
        writerService.writeToFile(REPORT_SOURCE_PATH);
    }
}
