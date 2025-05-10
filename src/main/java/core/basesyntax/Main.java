package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.fileservice.CsvFileReaderService;
import core.basesyntax.fileservice.CsvFileWriterService;
import core.basesyntax.fileservice.impl.CsvFileReaderServiceImpl;
import core.basesyntax.fileservice.impl.CsvFileWriterServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.sevrice.CsvFruitTransactionParser;
import core.basesyntax.sevrice.FruitService;
import core.basesyntax.sevrice.ReportCreator;
import core.basesyntax.sevrice.impl.CsvFruitTransactionParserImpl;
import core.basesyntax.sevrice.impl.FruitServiceImpl;
import core.basesyntax.sevrice.impl.ReportCreatorImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.strategyimpl.BalanceOperationHandler;
import core.basesyntax.strategy.strategyimpl.OperationStrategyImpl;
import core.basesyntax.strategy.strategyimpl.PurchaseOperationHandler;
import core.basesyntax.strategy.strategyimpl.ReturnOperationHandler;
import core.basesyntax.strategy.strategyimpl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FROM_FILE = "src/main/resources/dailyActivities.csv";
    private static final String WRITE_TO_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap
                = new HashMap<>() {
                    {
                        put(FruitTransaction.Operation.BALANCE,
                                new BalanceOperationHandler(fruitDao));
                        put(FruitTransaction.Operation.PURCHASE,
                                new PurchaseOperationHandler(fruitDao));
                        put(FruitTransaction.Operation.SUPPLY,
                                new SupplyOperationHandler(fruitDao));
                        put(FruitTransaction.Operation.RETURN,
                                new ReturnOperationHandler(fruitDao));
                    }
                };
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        List<String> strings = csvFileReaderService.readFromFile(READ_FROM_FILE);
        CsvFruitTransactionParser csvFruitTransactionParser = new CsvFruitTransactionParserImpl();
        List<FruitTransaction> parse = csvFruitTransactionParser.parse(strings);
        FruitService fruitService = new FruitServiceImpl(fruitDao, operationStrategy);
        for (FruitTransaction transaction : parse) {
            fruitService.calculate(transaction);
        }
        ReportCreator creator = new ReportCreatorImpl(fruitDao);
        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        csvFileWriterService.writeToFile(creator.createReport(), WRITE_TO_FILE);
    }
}
