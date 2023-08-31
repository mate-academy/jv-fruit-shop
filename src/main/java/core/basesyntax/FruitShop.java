package core.basesyntax;

import core.basesyntax.service.ConvertService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ProcessTransactionService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.serviceimpl.BalanceOperationService;
import core.basesyntax.serviceimpl.ConvertServiceImpl;
import core.basesyntax.serviceimpl.FruitStrategy;
import core.basesyntax.serviceimpl.FruitTransaction;
import core.basesyntax.serviceimpl.ProcessTransactionServiceImpl;
import core.basesyntax.serviceimpl.PurchaseOperationService;
import core.basesyntax.serviceimpl.ReaderServiceImpl;
import core.basesyntax.serviceimpl.ReportService;
import core.basesyntax.serviceimpl.SupplyReturnOperationService;
import core.basesyntax.serviceimpl.WriterServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private static final String pathToRead = "src/main/resources/filename.csv";
    private static final String pathToWrite = "src/main/resources/result.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put("s", new SupplyReturnOperationService());
        operationHandlers.put("r", new SupplyReturnOperationService());
        operationHandlers.put("p", new PurchaseOperationService());
        operationHandlers.put("b", new BalanceOperationService());

        ReaderService readerService = new ReaderServiceImpl();
        List<String> fileLines = readerService.read(pathToRead);

        ConvertService convertService = new ConvertServiceImpl();
        List<FruitTransaction> transactions = convertService.convert(fileLines);
        FruitStrategy fruitStrategy = new FruitStrategy(operationHandlers);
        ProcessTransactionService processData = new ProcessTransactionServiceImpl(fruitStrategy);
        processData.processData(transactions);
        WriterService writerService = new WriterServiceImpl();
        ReportService reportService = new ReportService();

        writerService.writeToFile(pathToWrite, reportService.createReport());
    }

}
