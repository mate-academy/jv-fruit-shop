package java.core.basesyntax;

import java.core.basesyntax.dao.FruitDao;
import java.core.basesyntax.dao.FruitDaoImpl;
import java.core.basesyntax.model.Operation;
import java.core.basesyntax.service.ReportService;
import java.core.basesyntax.service.impl.FruitServiceImpl;
import java.core.basesyntax.service.impl.ReportServiceImpl;
import java.core.basesyntax.strategy.FruitOperationStrategy;
import java.core.basesyntax.strategy.impl.BalanceOperationStrategy;
import java.core.basesyntax.strategy.impl.DecreaseQuantityStrategy;
import java.core.basesyntax.strategy.impl.IncreaseQuantityStrategy;
import java.util.List;
import java.util.Map;
import java.core.basesyntax.model.FruitTransaction;
import java.core.basesyntax.service.FileReaderService;
import java.core.basesyntax.service.FileWriterService;
import java.core.basesyntax.service.FruitService;
import java.core.basesyntax.service.Parser;
import java.core.basesyntax.service.impl.FileReaderServiceImpl;
import java.core.basesyntax.service.impl.FileWriterServiceImpl;
import java.core.basesyntax.service.impl.ParserImpl;

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
