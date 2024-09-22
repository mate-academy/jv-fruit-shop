package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperation;
import core.basesyntax.operation.ReturnOperation;
import core.basesyntax.operation.SupplyOperation;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.sevice.impl.DataParserImpl;
import core.basesyntax.sevice.impl.FileReaderImpl;
import core.basesyntax.sevice.impl.FileWriterImpl;
import core.basesyntax.sevice.impl.ReportGeneratorImpl;
import core.basesyntax.sevice.impl.ShopServiceImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_FROM = "src/main/resources/input.csv";
    private static final String FILE_TO = "output";
    private static final Map<FruitTransaction.Operation, OperationHandler> operationMap = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceOperation(),
            FruitTransaction.Operation.SUPPLY, new SupplyOperation(),
            FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
            FruitTransaction.Operation.RETURN, new ReturnOperation());

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.readFromFile(FILE_FROM);

        DataParser dataParser = new DataParserImpl();
        List<FruitTransaction> transactions = dataParser.parse(inputReport);

        Strategy strategy = new StrategyImpl(operationMap);
        ShopService shopService = new ShopServiceImpl(strategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.createReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(FILE_TO, resultingReport);
    }
}
