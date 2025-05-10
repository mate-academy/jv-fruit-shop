package core.basesyntax;

import core.basesyntax.model.FruitTransactionImpl;
import core.basesyntax.operationhandlers.BalanceOperationHandler;
import core.basesyntax.operationhandlers.OperationHandler;
import core.basesyntax.operationhandlers.PurchaseOperationHandler;
import core.basesyntax.operationhandlers.ReturnOperationHandler;
import core.basesyntax.operationhandlers.SupplyOperationHandler;
import core.basesyntax.service.CustomFileReader;
import core.basesyntax.service.CustomFileWriter;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String FILE_PATH_INPUT_FILE = "src/main/resources/reportToRead.csv";
    public static final String FILE_PATH_OUTPUT_FILE = "src/main/resources/finalReport.csv";

    public static void main(String[] arg) {
        CustomFileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read();

        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransactionImpl> transactions = dataConverter
                .convertToTransaction(inputReport);

        Map<FruitTransactionImpl.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransactionImpl.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlers.put(FruitTransactionImpl.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlers.put(FruitTransactionImpl.Operation.RETURN,
                new ReturnOperationHandler());
        operationHandlers.put(FruitTransactionImpl.Operation.SUPPLY,
                new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        CustomFileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport);
    }
}
