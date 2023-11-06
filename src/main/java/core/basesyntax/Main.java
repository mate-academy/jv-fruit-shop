package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitConverter;
import core.basesyntax.service.OperationProcess;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitConverterImpl;
import core.basesyntax.service.impl.OperationProcessImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.WriterServiceImp;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_TO_READ = "src/main/resources/input.csv";
    private static final String FILE_TO_WRITE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> allLines = readerService.read(FILE_TO_READ);
        FruitConverter fruitMapper = new FruitConverterImpl();
        List<FruitTransaction> fruitTransactions = fruitMapper.convertData(allLines);
        Map<Operation, OperationHandler> handlers = createOperationHandlers();
        OperationStrategy operationStrategy = new OperationStrategy(handlers);
        OperationProcess operationProcess = new OperationProcessImpl(operationStrategy);
        operationProcess.processTransaction(fruitTransactions);
        ReportCreator createReport = new ReportCreatorImpl();
        String report = createReport.createReport(Storage.SHOPSTORAGE);
        WriterService writerService = new WriterServiceImp();
        writerService.writeFile(report, FILE_TO_WRITE);
    }

    private static Map<Operation, OperationHandler> createOperationHandlers() {
        return Map.of(
                Operation.BALANCE, new BalanceOperationHandler(),
                Operation.SUPPLY, new SupplyOperationHandler(),
                Operation.PURCHASE, new PurchaseOperationHandler(),
                Operation.RETURN, new ReturnOperationHandler()
        );
    }
}
