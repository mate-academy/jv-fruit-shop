package core.basesyntax;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReadFile;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReadFileImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DATA_FILE = "src/main/resources/reportToRead.csv";
    private static final String REPORT_FILE = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        ReadFile reportOfFile = new ReadFileImpl();
        List<String> readFile = reportOfFile.read(DATA_FILE);

        DataConverter dataConverter = new DataConverterImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(readFile);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        Map<String, Integer> finalStorage = shopService.process(transactions);

        ReportGenerator report = new ReportGeneratorImpl();
        String resultingReport = report.getReport(finalStorage);

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, REPORT_FILE);
    }
}
