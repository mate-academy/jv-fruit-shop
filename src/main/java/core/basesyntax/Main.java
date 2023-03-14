package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FileReaderService;
import core.basesyntax.service.impl.FileWriterService;
import core.basesyntax.strategy.FactoryStrategy;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.impl.BalanceOperationStrategy;
import core.basesyntax.strategy.impl.PurchaseOperationStrategy;
import core.basesyntax.strategy.impl.ReturnOperationStrategy;
import core.basesyntax.strategy.impl.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/data.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        ReaderService fileReaderService = new FileReaderService();
        List<String> dataFromFile = fileReaderService.read(INPUT_FILE_NAME);
        TransactionParserService parserService = new TransactionParserService();
        List<FruitTransaction> listFruitTransactions =
                parserService.parse(dataFromFile);
        FruitShopService fruitShopService
                = new FruitShopService(new FactoryStrategy(getStrategies(fruitDao)));
        fruitShopService.processing(listFruitTransactions);
        ReportService reportService = new ReportService(fruitDao);
        WriterService fileWriterService = new FileWriterService();
        fileWriterService.write(REPORT_FILE_NAME, reportService.generateReport());
    }

    private static Map<FruitTransaction.Operation, Operation> getStrategies(FruitDao fruitDao) {
        Map<FruitTransaction.Operation, Operation> strategies = new HashMap<>();
        strategies.put(
                FruitTransaction.Operation.BALANCE, new BalanceOperationStrategy(fruitDao));
        strategies.put(
                FruitTransaction.Operation.SUPPLY, new SupplyOperationStrategy(fruitDao));
        strategies.put(
                FruitTransaction.Operation.RETURN, new ReturnOperationStrategy(fruitDao));
        strategies.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationStrategy(fruitDao));
        return strategies;
    }
}
