package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationsToMapService;
import core.basesyntax.service.ParserInFruitTransaction;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.OperationsToMapServiceImpl;
import core.basesyntax.service.impl.ParserInFruitTransactionImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.impl.FruitStrategyImpl;
import java.util.List;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/listAllOperation.csv";
    private static final String PATH_TO_REPORT = "src/main/resources/countProduct.csv";

    public static void main(String[] args) {
        OperationsToMapService operationsToMapService = new OperationsToMapServiceImpl();
        ReadService readService = new ReadServiceImpl();
        ParserInFruitTransaction parser = new ParserInFruitTransactionImpl();
        FruitStrategy fruitStrategy =
                new FruitStrategyImpl(operationsToMapService.operationsToMap());
        FruitService fruitService = new FruitServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> strings = readService.readFromFile(PATH_TO_INPUT_FILE);
        List<FruitTransaction> fruitTransactions = parser.parseData(strings);

        fruitService.getAllTypeStrategy(fruitTransactions, fruitStrategy);
        writerService.write(PATH_TO_REPORT,reportService.reportStorage());
    }
}
