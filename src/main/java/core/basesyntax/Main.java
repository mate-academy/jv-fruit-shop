package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConvertorService;
import core.basesyntax.service.CreatorService;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.StrategyService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ConvertorServiceImpl;
import core.basesyntax.service.impl.CreatorServiceImpl;
import core.basesyntax.service.impl.FruitTransactionProcessorImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.StrategyServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
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
    private static final String OUTPUT_FILE =
            "/Users/macbook/IdeaProjects/jv-fruit-shop/src/main/resources/fileReport.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, StrategyHandler> strategyHandlerMap = new HashMap<>();
        strategyHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceStrategyHandlerImpl(fruitDao));
        strategyHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyStrategyHandlerImpl(fruitDao));
        strategyHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseStrategyHandlerImpl(fruitDao));
        strategyHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnStrategyHandlerImpl(fruitDao));
        ReaderService readerService = new ReaderServiceImpl();
        List<String> readFromFile = readerService.readFile(FILE_PATH);
        ConvertorService convertorService = new ConvertorServiceImpl();
        List<FruitTransaction> fruitTransactionList = convertorService.convertData(readFromFile);
        StrategyService strategyService = new StrategyServiceImpl(strategyHandlerMap);
        FruitTransactionProcessor calculatorService =
                new FruitTransactionProcessorImpl(fruitDao, strategyService);
        calculatorService.fillStorage(fruitTransactionList);
        CreatorService reportCreator = new CreatorServiceImpl();
        String report = reportCreator.createReport(fruitDao.getFruitMap());
        WriterService writerService = new WriterServiceImpl();
        writerService.write(OUTPUT_FILE, report);
    }
}
