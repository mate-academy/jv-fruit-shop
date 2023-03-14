package core.basesyntax;

import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.ActionStrategy;
import core.basesyntax.strategy.actions.ActionHandler;
import core.basesyntax.strategy.actions.BaseActionHandler;
import core.basesyntax.strategy.actions.PurchaseActionHandler;
import core.basesyntax.strategy.actions.ReturnActionHandler;
import core.basesyntax.strategy.actions.SupplyActionHandler;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Storage storage = new Storage();
    private static final String FROM = "src/main/resources/test.csv";
    private static final String TO = "src/main/resources/";

    public static void main(String[] args) {
        ActionStrategy strategy = new ActionStrategy(allPossibleActions());
        ReaderService reader = new ReaderServiceImpl();
        WriterService writer = new WriterServiceImpl();
        TransactionParserService parser = new TransactionParserServiceImpl();
        ReportMakerService reportMaker = new ReportMakerServiceImpl();
        parser.parse(reader.read(FROM))
                .forEach(transaction ->
                        strategy.get(transaction.getOperation()).apply(storage,
                                transaction.getFruit(),
                                transaction.getQuantity()));
        writer.write(reportMaker.report(storage.getFruits()), TO);
    }

    private static List<ActionHandler> allPossibleActions() {
        List<ActionHandler> possibleActions = new ArrayList<>();
        possibleActions.add(new BaseActionHandler());
        possibleActions.add(new PurchaseActionHandler());
        possibleActions.add(new SupplyActionHandler());
        possibleActions.add(new ReturnActionHandler());
        return possibleActions;
    }
}
