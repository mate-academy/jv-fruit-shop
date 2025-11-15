package core.basesyntax;

import core.basesyntax.db.ShopStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.file.ShopFileReader;
import core.basesyntax.service.file.ShopFileWriter;
import core.basesyntax.service.file.impl.ShopFileReaderImpl;
import core.basesyntax.service.file.impl.ShopFileWriterImpl;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String REPORT_TO_READ_PATH = "src/main/resources/reportToRead.csv";
    private static final String FINAL_REPORT_PATH = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        ShopStorage storage = new ShopStorage();

        ShopFileReader fileReader = new ShopFileReaderImpl();
        List<String> inputReport =
                fileReader.readCsv(REPORT_TO_READ_PATH);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransactions(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy, storage);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String resultingReport = reportGenerator.getReport();

        ShopFileWriter fileWriter = new ShopFileWriterImpl();
        fileWriter.write(resultingReport, FINAL_REPORT_PATH);
    }
}
