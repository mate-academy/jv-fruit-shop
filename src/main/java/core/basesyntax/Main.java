package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.impl.FileReaderCsv;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReportGenerator;
import core.basesyntax.service.impl.TransactionExecutor;
import core.basesyntax.service.impl.Writer;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH_EXAMPLE = "src/main/resources/example.csv";
    private static final String FILE_PATH_REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> strategyMap = new HashMap<>();
        strategyMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        strategyMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        strategyMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        strategyMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());

        FileReader fileReader = new FileReaderCsv();
        FruitTransactionParserImpl transactionParser = new FruitTransactionParserImpl();
        ReportGenerator reportGenerator = new ReportGenerator();
        Writer writer = new Writer();
        TransactionExecutor transactionExecutor = new TransactionExecutor(strategyMap);

        List<String> strings = fileReader.read(FILE_PATH_EXAMPLE);
        List<FruitTransaction> parsed = transactionParser.parse(strings);

        transactionExecutor.execute(parsed);
        writer.writeInFile(FILE_PATH_REPORT,
                reportGenerator.generateReport(Storage.fruits));
    }
}
