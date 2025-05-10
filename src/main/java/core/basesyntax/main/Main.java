package core.basesyntax.main;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FruitShopDao;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FruitShopDaoImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceHandlerImpl;
import core.basesyntax.strategy.impl.FruitStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseHandlerImpl;
import core.basesyntax.strategy.impl.ReturnHandlerImpl;
import core.basesyntax.strategy.impl.SupplyHandlerImpl;
import core.basesyntax.utility.ListService;
import core.basesyntax.utility.impl.ListServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH_INPUT = "src/main/resources/inputFile.csv";
    private static final String FILE_PATH_OUTPUT = "src/main/resources/outputFile.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> csvFile = readerService.readFile(FILE_PATH_INPUT);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> fruitTransactions = dataConverter.convertToTransactions(csvFile);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        ListService listService = new ListServiceImpl();
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceHandlerImpl(listService));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseHandlerImpl(listService));
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnHandlerImpl(listService));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyHandlerImpl(listService));

        FruitStrategy fruitStrategy = new FruitStrategyImpl(operationHandlers);
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();

        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(fruitShopDao, fruitStrategy);
        Map<String, Integer> fruitsQuantityAfterDay =
                fruitTransactionService.processTransactions(fruitTransactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String generatedReport = reportGenerator.generateReport(fruitsQuantityAfterDay);

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToCsv(generatedReport, FILE_PATH_OUTPUT);
    }
}
