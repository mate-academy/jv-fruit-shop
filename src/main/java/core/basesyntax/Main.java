package core.basesyntax;

import core.basesyntax.database.FruitStock;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ShopService;
import core.basesyntax.serviceimpl.DataConverterImpl;
import core.basesyntax.serviceimpl.FileReaderImpl;
import core.basesyntax.serviceimpl.FileWriterImpl;
import core.basesyntax.serviceimpl.ReportGenerator;
import core.basesyntax.serviceimpl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategyimpl.BalanceHandler;
import core.basesyntax.strategyimpl.OperationStrategyImpl;
import core.basesyntax.strategyimpl.PurchaseHandler;
import core.basesyntax.strategyimpl.ReturnHandler;
import core.basesyntax.strategyimpl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/reportToRead.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.csv");

        DataConverter dataConverter = new DataConverterImpl();
        FruitStock fruitStock = new FruitStock();
        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceHandler(fruitStock));
        operationHandlers.put(Operation.PURCHASE, new PurchaseHandler(fruitStock));
        operationHandlers.put(Operation.RETURN, new ReturnHandler(fruitStock));
        operationHandlers.put(Operation.SUPPLY, new SupplyHandler(fruitStock));

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(fruitStock, operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGenerator(fruitStock);
        String resultingReport = reportGenerator.generateReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}
