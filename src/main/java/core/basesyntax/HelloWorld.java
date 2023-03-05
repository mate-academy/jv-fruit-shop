package core.basesyntax;

import core.basesyntax.actions.BalanceAction;
import core.basesyntax.actions.DoingAction;
import core.basesyntax.actions.PurchaseAction;
import core.basesyntax.actions.ReturnAction;
import core.basesyntax.actions.SupplyAction;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportCounter;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportCounterImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.StrategyOptions;
import core.basesyntax.strategy.StrategyOptionsImpl;
import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, DoingAction> doingStrategy = new HashMap<>();
        doingStrategy.put(FruitTransaction.Operation.BALANCE, new BalanceAction());
        doingStrategy.put(FruitTransaction.Operation.SUPPLY, new SupplyAction());
        doingStrategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseAction());
        doingStrategy.put(FruitTransaction.Operation.RETURN, new ReturnAction());

        ReaderImpl reader = new ReaderImpl();
        reader.readerTransaction("src/main/resources/testInput.csv");
        StrategyOptions strategyOptions = new StrategyOptionsImpl(doingStrategy);
        ReportCounter reportCounter = new ReportCounterImpl(strategyOptions);
        Fruit[] fruits = reportCounter.countReport();
        Writer writer = new WriterImpl();
        writer.writeReport("src/main/resources/testOutput.csv", fruits);
    }
}
