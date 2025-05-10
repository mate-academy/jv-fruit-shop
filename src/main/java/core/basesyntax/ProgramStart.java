package core.basesyntax;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.Processor;
import core.basesyntax.service.ReportProvider;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.ReportProviderImpl;
import core.basesyntax.service.impl.TransactionParser;
import core.basesyntax.service.impl.TransactionProcessor;
import core.basesyntax.service.strategy.operations.BalanceStrategy;
import core.basesyntax.service.strategy.operations.PurchaseStrategy;
import core.basesyntax.service.strategy.operations.ReturnStrategy;
import core.basesyntax.service.strategy.operations.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramStart {
    private static final String REPORT_FILE = "src/main/resources/report.csv";
    private static final String DATA_FILE = "src/main/resources/input.csv";

    public static void main(String[] args) {

        Map<String, OperationHandler> services = new HashMap<>();
        services.put("b", new BalanceStrategy());
        services.put("s", new SupplyStrategy());
        services.put("r", new ReturnStrategy());
        services.put("p", new PurchaseStrategy());

        FileService fileService = new FileServiceImpl();
        List<FruitTransaction> fruitTransactions = new TransactionParser()
                .parseData(fileService.readFromFile(DATA_FILE));
        Processor transactionProcessor = new TransactionProcessor(fruitTransactions, services);
        transactionProcessor.process();
        ReportProvider reportService = new ReportProviderImpl();
        fileService.writeToFile(REPORT_FILE, reportService.provide());
    }
}
