package core.basesyntax;

import core.basesyntax.db.MapStorage;
import core.basesyntax.db.Storage;
import core.basesyntax.mapper.FruitTransactionMapper;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationHandlerStrategy;
import core.basesyntax.service.strategy.impl.*;

import java.util.List;
import java.util.Map;

public class FruitShopApplication {
    private final FileReader fileReader;
    private final FileWriter fileWriter;
    private final FruitTransactionMapper mapper;
    private final FruitTransactionProcessor processor;
    private final FruitService fruitService;
    private final ReportService reportService;

    public FruitShopApplication() {
        fileReader = new FileReaderImpl();
        mapper = new FruitTransactionMapper();
        Storage storage = new MapStorage();
        fruitService = new FruitServiceImpl(storage);
        Map<FruitTransaction.Operation, OperationHandler> handlersMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(fruitService),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler(fruitService),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(fruitService),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(fruitService)
        );
        OperationHandlerStrategy strategy = new OperationHandlerStrategyImpl(
                handlersMap
        );
        processor = new FruitTransactionProcessorImpl(
                strategy
        );
        reportService = new ReportServiceImpl();
        fileWriter = new FileWriterImpl();
    }

    public void run(String pathToInputFile, String pathToOutputFile) {
        List<String> lines = fileReader.readFromFile(pathToInputFile);
        List<FruitTransaction> fruitTransactions = mapper.mapToFruitTransactions(lines);
        processor.process(fruitTransactions);
        String report = reportService.generateReport(fruitService.getAll());
        fileWriter.writeToFile(pathToOutputFile, report);
    }
}
