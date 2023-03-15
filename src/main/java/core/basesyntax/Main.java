package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.ActionStrategyImpl;
import core.basesyntax.strategy.actions.BalanceActionHandler;
import core.basesyntax.strategy.actions.PurchaseActionHandler;
import core.basesyntax.strategy.actions.ReturnActionHandler;
import core.basesyntax.strategy.actions.SupplyActionHandler;
import java.util.Map;

public class Main {
    private static final ReaderService reader = new ReaderServiceImpl();
    private static final WriterService writer = new WriterServiceImpl();
    private static final TransactionParserService parser = new TransactionParserServiceImpl();
    private static final ReportMakerService reportMaker = new ReportMakerServiceImpl();
    private static final String FROM = "src/main/resources/test.csv";
    private static final String TO = "src/main/resources/out.csv";
    private static final ActionStrategyImpl strategy =
            new ActionStrategyImpl(Map.of(
                    FruitTransaction.Operation.BALANCE, new BalanceActionHandler(),
                    FruitTransaction.Operation.PURCHASE, new PurchaseActionHandler(),
                    FruitTransaction.Operation.SUPPLY, new SupplyActionHandler(),
                    FruitTransaction.Operation.RETURN, new ReturnActionHandler()
            ));

    public static void main(String[] args) {
        parser.parse(reader.read(FROM))
                .forEach(transaction ->
                        strategy.get(transaction.getOperation()).apply(
                                transaction));
        writer.write(reportMaker.report(Storage.getFruits()), TO);
    }
}
