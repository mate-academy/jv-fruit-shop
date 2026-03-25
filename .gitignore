package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT = "src/main/resources/input.csv";
    private static final String OUTPUT = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FileReaderService reader = new FileReaderServiceImpl();
        DataConverter converter = new DataConverterImpl();
        FileWriterService writer = new FileWriterServiceImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        FruitShopService service = new FruitShopServiceImpl(strategy);

        List<String> lines = reader.read(INPUT);
        List<FruitTransaction> transactions = converter.convertToTransaction(lines);

        service.process(transactions);

        String report = reportGenerator.getReport(Storage.fruits);
        writer.write(report, OUTPUT);
    }
}

