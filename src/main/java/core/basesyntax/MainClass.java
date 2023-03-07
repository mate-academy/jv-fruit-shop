package core.basesyntax;

import core.basesyntax.actions.BalanceAction;
import core.basesyntax.actions.DoingAction;
import core.basesyntax.actions.PurchaseAction;
import core.basesyntax.actions.ReturnAction;
import core.basesyntax.actions.SupplyAction;
import core.basesyntax.model.FruitDto;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitCounter;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.SaveService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.FruitCounterImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.SaveServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.StrategyOptions;
import core.basesyntax.strategy.StrategyOptionsImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {
    private static final String FILE_INPUT = "src/main/resources/testInput.csv";
    private static final String FILE_OUTPUT = "src/main/resources/testOutput.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, DoingAction> operationStrategy = new HashMap<>();
        operationStrategy.put(FruitTransaction.Operation.BALANCE, new BalanceAction());
        operationStrategy.put(FruitTransaction.Operation.SUPPLY, new SupplyAction());
        operationStrategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseAction());
        operationStrategy.put(FruitTransaction.Operation.RETURN, new ReturnAction());

        ReaderService reader = new ReaderServiceImpl();
        List<String> strings = reader.readTransactionWithFile(FILE_INPUT);

        SaveService saved = new SaveServiceImpl();
        saved.saveToDb(strings);

        StrategyOptions strategyOptions = new StrategyOptionsImpl(operationStrategy);
        FruitCounter fruitCounter = new FruitCounterImpl(strategyOptions);
        List<FruitDto> fruits = fruitCounter.countReport();

        ReportService reportCreated = new ReportServiceImpl();
        String report = reportCreated.createReport(fruits);

        WriteService writer = new WriteServiceImpl();
        writer.writeReport(FILE_OUTPUT, report);
    }
}
