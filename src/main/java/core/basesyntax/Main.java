package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportReader;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ReportReaderImpl;
import core.basesyntax.service.impl.ReportWriterImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.strategy.BalanceOperation;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import core.basesyntax.service.strategy.PurchaseOperation;
import core.basesyntax.service.strategy.ReturnOperation;
import core.basesyntax.service.strategy.SupplyOperation;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_REPORT = "src/main/resources/reportToRead.csv";
    private static final String FINAL_REPORT = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        ReportReader reader = new ReportReaderImpl();
        List<String> lines = reader.read(INPUT_REPORT);

        DataConverter converter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers =
                new EnumMap<>(FruitTransaction.Operation.class);
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlers);

        List<FruitTransaction> transactions = converter.toTransactions(lines);

        ShopService shopService = new ShopServiceImpl(strategy);
        Map<String, Integer> fruits = shopService.process(transactions);

        ReportGenerator generator = new ReportGeneratorImpl();
        String resultingReport = generator.build(fruits);

        ReportWriter writer = new ReportWriterImpl();
        writer.write(resultingReport, FINAL_REPORT);
    }
}
