package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReport;
import core.basesyntax.service.FruitMapper;
import core.basesyntax.service.OperationProcess;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CreateReportImpl;
import core.basesyntax.service.impl.FruitMapperImpl;
import core.basesyntax.service.impl.OperationProcessImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
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
        FruitMapper fruitMapper = new FruitMapperImpl();
        List<FruitTransaction> fruitTransactions = fruitMapper.convertData(allLines);
        Map<FruitTransaction.Operation, OperationHandler> handlers = createOperationHandlers();
        OperationStrategy operationStrategy = new OperationStrategy(handlers);
        OperationProcess operationProcess = new OperationProcessImpl(operationStrategy);
        operationProcess.processTransaction(fruitTransactions);
        CreateReport createReport = new CreateReportImpl();
        String report = createReport.writeReport(Storage.shopStorage);
        WriterService writerService = new WriterServiceImp();
        boolean isSuccessWrite = writerService.writeCvsFile(report, FILE_TO_WRITE);
        System.out.println(isSuccessWrite);
    }

    private static Map<FruitTransaction.Operation, OperationHandler> createOperationHandlers() {
        return Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler()
        );
    }
}
