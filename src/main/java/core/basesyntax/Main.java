package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operations.Balancer;
import core.basesyntax.strategy.operations.OperationCompiler;
import core.basesyntax.strategy.operations.Purchaser;
import core.basesyntax.strategy.operations.Returner;
import core.basesyntax.strategy.operations.Supplier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Reader reader = new ReaderImpl();
    private static Parser parser = new ParserImpl();
    private static Writer writer = new WriterImpl();
    private static final String INPUT_FILE_PATH = "src/main/resources/fruits.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationCompiler> operationCompilerMap = new HashMap<>();
        operationCompilerMap.put(FruitTransaction.Operation.BALANCE, new Balancer());
        operationCompilerMap.put(FruitTransaction.Operation.SUPPLY, new Supplier());
        operationCompilerMap.put(FruitTransaction.Operation.PURCHASE, new Purchaser());
        operationCompilerMap.put(FruitTransaction.Operation.RETURN, new Returner());

        List<String> fruitsList = reader.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = parser.parseFile(fruitsList);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationCompilerMap);

        for (FruitTransaction ft : fruitTransactions) {
            operationStrategy.get(ft.getOperation()).doOperation(ft);
        }

        ReportCreator report = new ReportCreatorImpl();

        writer.writeToFile(report.createReport(Storage.fruits), OUTPUT_FILE_PATH);
    }
}
