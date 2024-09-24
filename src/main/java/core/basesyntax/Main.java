package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
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
import core.basesyntax.serviceimpl.DataParserImpl;
import core.basesyntax.serviceimpl.FileReaderImpl;
import core.basesyntax.serviceimpl.FileWriterImpl;
import core.basesyntax.serviceimpl.ReportGeneratorImpl;
import core.basesyntax.serviceimpl.ShopServiceImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_FROM = "src/main/resources/input.csv";
    private static final String FILE_TO = "src/main/resources/output.csv";
    private static final Map<Operation, OperationHandler> operationMap = Map.of(
            Operation.BALANCE, new BalanceOperation(),
            Operation.SUPPLY, new SupplyOperation(),
            Operation.PURCHASE, new PurchaseOperation(),
            Operation.RETURN, new ReturnOperation());

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
