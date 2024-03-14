package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitParserServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitReportGeneratorImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationStrategy;
import core.basesyntax.strategy.impl.FruitStrategy;
import core.basesyntax.strategy.impl.PurchaseOperationStrategy;
import core.basesyntax.strategy.impl.ReturnOperationStrategy;
import core.basesyntax.strategy.impl.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String fromFile = "src/main/resources/fruits.csv";
    private static final String toFile = "src/main/resources/report.csv";
    private static final Map<Operation, OperationHandler> operationMap = new HashMap<>();
    private static final FruitDao fruitDao = new FruitDaoImpl();

    public static void main(String[] args) {
        fillMapWithStrategies();
        ReaderService fileReaderService = new FileReaderServiceImpl();
        ParserService fruitParserService = new FruitParserServiceImpl();
        ReportGenerator fruitReportGenerator = new FruitReportGeneratorImpl();
        WriterService fileWriterService = new FileWriterServiceImpl();
        FruitStrategy fruitStrategy = new FruitStrategy(operationMap);

        List<String> commands = fileReaderService.readFromFile(fromFile);
        List<FruitTransaction> fruitTransactions = fruitParserService.parse(commands);
        fruitStrategy.executeOperationServiceByOperation(fruitTransactions);
        String report = fruitReportGenerator.generateReport(fruitDao.getAll());
        fileWriterService.writeToFile(toFile, report);
    }

    private static void fillMapWithStrategies() {
        operationMap.put(Operation.BALANCE, new BalanceOperationStrategy(fruitDao));
        operationMap.put(Operation.PURCHASE, new PurchaseOperationStrategy(fruitDao));
        operationMap.put(Operation.SUPPLY, new SupplyOperationStrategy(fruitDao));
        operationMap.put(Operation.RETURN, new ReturnOperationStrategy(fruitDao));
    }
}
