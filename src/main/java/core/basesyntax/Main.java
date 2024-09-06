package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.MyFileReader;
import core.basesyntax.service.MyFileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.MyFileReaderImpl;
import core.basesyntax.service.impl.MyFileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.FruitStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperation;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperation;
import core.basesyntax.strategy.operation.ReturnOperation;
import core.basesyntax.strategy.operation.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILENAME_TO_READ = "reportToRead.csv";
    private static final String FILENAME_TO_WRITE = "finalReport.csv";

    public static void main(String[] args) {
        MyFileReader fileReader = new MyFileReaderImpl();
        List<String> inputReport = fileReader.read(FILENAME_TO_READ);
        DataParser dataConverter = new DataParserImpl();
        List<FruitTransaction> transactions = dataConverter.parse(inputReport);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        initOperationHandlers(operationHandlers);
        FruitStrategy operationStrategy = new FruitStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.generateReport();
        MyFileWriter fileWriter = new MyFileWriterImpl();
        fileWriter.write(resultingReport, FILENAME_TO_WRITE);
    }

    private static void initOperationHandlers(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
    }
}
