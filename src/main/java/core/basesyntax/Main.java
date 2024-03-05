package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.FruitOperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationStrategy;
import core.basesyntax.strategy.impl.DecreaseQuantityStrategy;
import core.basesyntax.strategy.impl.IncreaseQuantityStrategy;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Operation, FruitOperationStrategy> strategyMap;
    private static final String inputFileName = "src/main/java/resources/data.csv";
    private static final String reportFileName = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        final List<String> fruitData = fileReaderService.readFromFile(inputFileName);

        Parser parser = new ParserImpl();
        List<FruitTransaction> fruitTransactions =
                parser.convertFruitDataToTransactions(fruitData);

        FruitDao fruitDao = new FruitDaoImpl();

        strategyMap = Map.of(Operation.BALANCE, new BalanceOperationStrategy(fruitDao),
                Operation.SUPPLY, new IncreaseQuantityStrategy(fruitDao),
                Operation.RETURN, new IncreaseQuantityStrategy(fruitDao),
                Operation.PURCHASE, new DecreaseQuantityStrategy(fruitDao));

        FruitService fruitService = new FruitServiceImpl(strategyMap);
        fruitService.processTransactions(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(fruitDao.getAllFruits());

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(reportFileName, report);
    }
}
