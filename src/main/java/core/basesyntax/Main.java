package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "reportToRead.csv";
    private static final String OUTPUT_FILE_PATH = "finalReport";

    public static void main(String[] args) throws IOException {
        FileReaderService fileReader = new FileReaderServiceImpl();
        List<String> inputReport = fileReader.read(INPUT_FILE_PATH);

        DataConverter dataConverter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.write(resultingReport, OUTPUT_FILE_PATH);
    }
}
