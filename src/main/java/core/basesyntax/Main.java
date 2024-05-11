package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConvertorService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.StrategyService;
import core.basesyntax.service.impl.DataConvertorServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionProcessorImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.StrategyServiceImpl;
import core.basesyntax.strategy.BalanceStrategyHandlerImpl;
import core.basesyntax.strategy.PurchaseStrategyHandlerImpl;
import core.basesyntax.strategy.ReturnStrategyHandlerImpl;
import core.basesyntax.strategy.StrategyHandler;
import core.basesyntax.strategy.SupplyStrategyHandlerImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH =
            "/Users/macbook/IdeaProjects/jv-fruit-shop/src/main/resources/InputFile.csv";
    private static final String OUTPUT_FILE =
            "/Users/macbook/IdeaProjects/jv-fruit-shop/src/main/resources/fileReport.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, StrategyHandler> strategyHandlerMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceStrategyHandlerImpl(fruitDao),
                FruitTransaction.Operation.SUPPLY, new SupplyStrategyHandlerImpl(fruitDao),
                FruitTransaction.Operation.PURCHASE, new PurchaseStrategyHandlerImpl(fruitDao),
                FruitTransaction.Operation.RETURN, new ReturnStrategyHandlerImpl(fruitDao)
        );
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> readFile = fileReaderService.readFile(FILE_PATH);
        DataConvertorService dataConvertorService = new DataConvertorServiceImpl();
        List<FruitTransaction> fruitTransactionList = dataConvertorService.convertData(readFile);
        StrategyService strategyService = new StrategyServiceImpl(strategyHandlerMap);
        FruitTransactionProcessor calculatorService =
                new FruitTransactionProcessorImpl(fruitDao, strategyService);
        calculatorService.fillStorage(fruitTransactionList);
        ReportCreatorService reportCreator = new ReportCreatorServiceImpl();
        String report = reportCreator.createReport(fruitDao.getFruitMap());
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(OUTPUT_FILE, report);
    }
}
