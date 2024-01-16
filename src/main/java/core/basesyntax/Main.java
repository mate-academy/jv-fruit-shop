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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String storeFileName = "src/main/resources/store.csv";
        final String reportFileName = "src/main/resources/report.csv";

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        final List<String> fruitData = fileReaderService.readFromFile(storeFileName);

        Parser parser = new ParserImpl();
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String data : fruitData) {
            FruitTransaction fruitTransaction = parser.parse(data);
            if (fruitTransaction != null) {
                fruitTransactions.add(fruitTransaction);
            }
        }

        FruitDao fruitDao = new FruitDaoImpl();
        
        Map<Operation, FruitOperationStrategy> strategyMap = new HashMap<>();
        strategyMap.put(Operation.BALANCE, new BalanceOperationStrategy(fruitDao));
        strategyMap.put(Operation.SUPPLY, new IncreaseQuantityStrategy(fruitDao));
        strategyMap.put(Operation.RETURN, new IncreaseQuantityStrategy(fruitDao));
        strategyMap.put(Operation.PURCHASE, new DecreaseQuantityStrategy(fruitDao));

        FruitService fruitService = new FruitServiceImpl(strategyMap);
        fruitService.processTransactions(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(fruitDao.getAllFruits());

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(reportFileName, report);
    }
}
