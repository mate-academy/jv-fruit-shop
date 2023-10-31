package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.CalculatorImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.FruitHandler;
import core.basesyntax.strategy.impl.BalanceImpl;
import core.basesyntax.strategy.impl.FruitHandlerStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseImpl;
import core.basesyntax.strategy.impl.ReturnImpl;
import core.basesyntax.strategy.impl.SupplyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String PATH_TO_INPUT_FILE = "src/main/resources/test.csv";
    public static final String PATH_TO_REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, FruitHandler> strategyMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceImpl(),
                FruitTransaction.Operation.PURCHASE, new PurchaseImpl(),
                FruitTransaction.Operation.RETURN, new ReturnImpl(),
                FruitTransaction.Operation.SUPPLY, new SupplyImpl());
        List<FruitTransaction> fruitTransactions = new ParserServiceImpl()
                .parseData(new ReaderServiceImpl()
                        .readFromFile(PATH_TO_INPUT_FILE));
        new CalculatorImpl(new FruitHandlerStrategyImpl(strategyMap)).calculate(fruitTransactions);
        String report = new ReportServiceImpl().createReport();
        WriterServiceImpl writerServiceImpl = new WriterServiceImpl();
        writerServiceImpl.writeToFile(PATH_TO_REPORT_FILE, report);
    }
}
