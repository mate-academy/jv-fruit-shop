package core.basesyntax;

import core.basesyntax.dao.FruitDaoTransaction;
import core.basesyntax.dao.FruitDaoTransactionImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConvertDataFromFile;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.StrategyService;
import core.basesyntax.service.impl.ConvertDataFromFileImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriteServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.StrategyServiceImpl;
import core.basesyntax.strategy.BalanceStrategyHandlerImpl;
import core.basesyntax.strategy.PurchaseStrategyHandlerImpl;
import core.basesyntax.strategy.ReturnStrategyHandlerImpl;
import core.basesyntax.strategy.StrategyHandler;
import core.basesyntax.strategy.SupplyStrategyHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH =
            "/Users/macbook/IdeaProjects/jv-fruit-shop/src/main/resources/InputFile.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, StrategyHandler> strategyHandlerMap = new HashMap<>();
        FruitDaoTransaction fruitDao =
                new FruitDaoTransactionImpl(new StrategyServiceImpl(strategyHandlerMap));
        strategyHandlerMap
                .put(FruitTransaction.Operation.BALANCE, new BalanceStrategyHandlerImpl(fruitDao));
        strategyHandlerMap
                .put(FruitTransaction.Operation.SUPPLY, new SupplyStrategyHandlerImpl(fruitDao));
        strategyHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseStrategyHandlerImpl(fruitDao));
        strategyHandlerMap
                .put(FruitTransaction.Operation.RETURN, new ReturnStrategyHandlerImpl(fruitDao));

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> readFromFile = fileReaderService.readFile(FILE_PATH);

        ConvertDataFromFile convertDataFromFile = new ConvertDataFromFileImpl();
        List<FruitTransaction> fruitTransactionList
                = convertDataFromFile.convertDataFromFile(readFromFile);

        StrategyService strategyService = new StrategyServiceImpl(strategyHandlerMap);
        FruitDaoTransaction fruitDaoTransaction = new FruitDaoTransactionImpl(strategyService);
        ReportService reportService = new ReportServiceImpl(fruitDaoTransaction);
        reportService.calculateDataForReport(fruitTransactionList);
        FileWriterService fileWriterService = new FileWriteServiceImpl();
        fileWriterService.writeReport(fruitDao.getFruitMap());
    }
}
