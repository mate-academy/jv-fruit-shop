package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        String dataFromFile = reader.readDataFromFile(INPUT_FILE_PATH);
        Parser parser = new ParserImpl();
        final List<FruitTransaction> fruitTransactions
                = parser.parseFruitTransactions(dataFromFile);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap
                = Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.processActivitiesWithFruits(fruitTransactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        Writer writer = new WriterImpl();
        writer.writeToFile(OUTPUT_FILE_PATH, reportGenerator.getReport());
    }
}
