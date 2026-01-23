package core.basesyntax;

import core.basesyntax.db.InMemoryStorage;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConvert;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.serviceimpl.DataConverterImpl;
import core.basesyntax.serviceimpl.FileReaderImpl;
import core.basesyntax.serviceimpl.FileWriterImpl;
import core.basesyntax.serviceimpl.OperationStrategyImpl;
import core.basesyntax.serviceimpl.ReportGeneratorImpl;
import core.basesyntax.serviceimpl.ShopServiceImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import core.basesyntax.utility.FruitTransactionValidator;
import core.basesyntax.utility.FruitTransactionValidatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("data.csv");

        DataConvert dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convert(inputReport);

        FruitTransactionValidator validator = new FruitTransactionValidatorImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(validator));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(validator));
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler(validator));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(validator));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        Storage storage = new InMemoryStorage();
        ShopService shopService = new ShopServiceImpl(operationStrategy, storage);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}
