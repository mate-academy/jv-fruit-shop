package core.basesyntax;

import core.basesyntax.actions.BalanceAction;
import core.basesyntax.actions.DoingAction;
import core.basesyntax.actions.PurchaseAction;
import core.basesyntax.actions.ReturnAction;
import core.basesyntax.actions.SupplyAction;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitCounter;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportCreated;
import core.basesyntax.service.Saved;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.FruitCounterImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportCreatedImpl;
import core.basesyntax.service.impl.SavedImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.StrategyOptions;
import core.basesyntax.strategy.StrategyOptionsImpl;
import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    private static final String FILE_INPUT = "src/main/resources/testInput.csv";
    private static final String FILE_OUTPUT = "src/main/resources/testOutput.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, DoingAction> doingStrategy = new HashMap<>();
        doingStrategy.put(FruitTransaction.Operation.BALANCE, new BalanceAction());
        doingStrategy.put(FruitTransaction.Operation.SUPPLY, new SupplyAction());
        doingStrategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseAction());
        doingStrategy.put(FruitTransaction.Operation.RETURN, new ReturnAction());

        Reader reader = new ReaderImpl();
        Saved saved = new SavedImpl();
        StrategyOptions strategyOptions = new StrategyOptionsImpl(doingStrategy);
        FruitCounter fruitCounter = new FruitCounterImpl(strategyOptions);
        ReportCreated reportCreated = new ReportCreatedImpl();
        Writer writer = new WriterImpl();
        String text = reader.readerTransaction(FILE_INPUT);
        saved.saveToDb(text);
        Fruit[] fruits = fruitCounter.countReport();
        String report = reportCreated.createReport(fruits);
        writer.writeReport(FILE_OUTPUT, report);
    }
}
