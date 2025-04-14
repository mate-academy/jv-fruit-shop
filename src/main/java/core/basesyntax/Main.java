package core.basesyntax;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.reader.FileReaderImpl;
import core.basesyntax.reader.FileReaderInterface;
import core.basesyntax.report.FileWriterImpl;
import core.basesyntax.report.FileWriterInterface;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.handler.BalanceOperation;
import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.service.handler.PurchaseOperation;
import core.basesyntax.service.handler.ReturnOperation;
import core.basesyntax.service.handler.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReaderInterface fileReader = new FileReaderImpl();
        List<String> lines = fileReader.read("src/main/java/core/basesyntax/resources/input.csv");

        DataConverter converter = new DataConverterImpl();
        final List<FruitTransaction> transactions = converter.convertToTransaction(lines);

        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(Operation.RETURN, new ReturnOperation());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperation());

        OperationStrategy strategy = new OperationStrategyImpl(operationHandlers);
        ShopService service = new ShopServiceImpl(strategy);
        service.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriterInterface fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport,
                "src/main/java/core/basesyntax/resources/finalReport.csv");
    }
}
