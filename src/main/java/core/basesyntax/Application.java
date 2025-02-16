package core.basesyntax;

import core.basesyntax.data.DataConverter;
import core.basesyntax.data.DataConverterImpl;
import core.basesyntax.data.FruitTransaction;
import core.basesyntax.file.reader.Reader;
import core.basesyntax.file.reader.ReaderImpl;
import core.basesyntax.file.writer.FileWriterImpl;
import core.basesyntax.file.writer.FileWriterInterface;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.resources.Resources;
import core.basesyntax.servises.ShopService;
import core.basesyntax.servises.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handlers.BalanceOperation;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.PurchaseOperation;
import core.basesyntax.strategy.handlers.ReturnOperation;
import core.basesyntax.strategy.handlers.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        List<String> inputReport = reader.read(Resources.REPORT_TO_READ_CSV);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriterInterface fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, Resources.FINAL_REPORT_CSV);
    }
}
