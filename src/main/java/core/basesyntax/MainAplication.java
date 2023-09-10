package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.CsvParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvParserImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class MainAplication {
    private static final String INPUT_FILE = "src/main/resources/indata.csv";
    private static final String OUTPUT_FILE = "src/main/resources/report.csv";
    private static final Map<Operation, OperationHandler> OPERATIONS_MAP;

    static {
        OPERATIONS_MAP = Map.of(
                Operation.BALANCE, new BalanceOperationHandler(),
                Operation.PURCHASE, new PurchaseOperationHandler(),
                Operation.RETURN, new ReturnOperationHandler(),
                Operation.SUPPLY, new SupplyOperationHandler()
        );
    }

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        ReaderService reader = new ReaderServiceImpl();
        CsvParserService parser = new CsvParserImpl();
        List<FruitTransaction> fruitsList = parser.parse(reader.readFromFile(INPUT_FILE));

        FruitServiceImpl fruitService = new FruitServiceImpl(fruitDao,
                new OperationStrategy(OPERATIONS_MAP));
        fruitService.updateFruitsInStock(fruitsList);

        ReportService reportService = new ReportServiceImpl(fruitDao);
        String report = reportService.buildReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(OUTPUT_FILE, report);
    }
}
