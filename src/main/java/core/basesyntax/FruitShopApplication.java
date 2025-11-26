package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ReadFileService;
import core.basesyntax.service.ReadFileServiceImpl;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.WriteFileService;
import core.basesyntax.service.WriteFileServiceImpl;
import core.basesyntax.service.converter.DataConverter;
import core.basesyntax.service.converter.DataConverterImpl;
import core.basesyntax.strategy.operation.BalanceOperation;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperation;
import core.basesyntax.strategy.operation.ReturnOperation;
import core.basesyntax.strategy.operation.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopApplication {
    private static final String FILE_PATH = "src/main/resources/fruits.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report_fruits.csv";

    public static void main(String[] args) {
        ReadFileService readFileService = new ReadFileServiceImpl();
        List<String> stringsFromFile = readFileService.readFromFile(FILE_PATH);

        FruitsDao fruitsDao = new FruitsDaoImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(fruitsDao));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperation(fruitsDao));
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation(fruitsDao));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation(fruitsDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions
                = dataConverter.convertFruitTransactions(stringsFromFile);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(fruitsDao);
        String resultingReport = reportGenerator.getReport();

        WriteFileService writeFileService = new WriteFileServiceImpl();
        writeFileService.writeReportToFile(resultingReport, REPORT_FILE_PATH);
    }
}
