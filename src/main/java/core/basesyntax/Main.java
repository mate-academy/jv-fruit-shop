package core.basesyntax;

import core.basesyntax.impl.DataParserImpl;
import core.basesyntax.impl.FileReaderImpl;
import core.basesyntax.impl.FileWriterImpl;
import core.basesyntax.impl.ProcessServiceImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperation;
import core.basesyntax.operation.ReturnOperation;
import core.basesyntax.operation.SupplyOperation;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ProcessService;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_FROM = "src/main/resources/input.csv";
    private static final String FILE_TO = "src/main/resources/output.csv";
    private static final Map<FruitTransaction.Operation, OperationHandler> operationMap = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceOperation(),
            FruitTransaction.Operation.SUPPLY, new SupplyOperation(),
            FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
            FruitTransaction.Operation.RETURN, new ReturnOperation());

    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        List<String> dataFromFile = reader.read(FILE_FROM);

        DataParser dataParser = new DataParserImpl();
        List<FruitTransaction> fruitTransactions = dataParser.parse(dataFromFile);

        Strategy strategy = new StrategyImpl(operationMap);

        ProcessService processService = new ProcessServiceImpl(strategy);
        processService.process(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeFile(FILE_TO, report);
    }
}
