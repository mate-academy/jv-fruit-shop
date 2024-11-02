package core.basesyntax;

import core.basesyntax.file.FileReader;
import core.basesyntax.file.FileReaderImpl;
import core.basesyntax.file.FileWriter;
import core.basesyntax.file.FileWriterImpl;
import core.basesyntax.model.OperationType;
import core.basesyntax.model.ShopOperation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.StrategyOperationService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.StrategyOperationServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_FILE = "reportToRead.csv";
    private static final String PATH_TO_REPORT_FILE = "finalReport.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(PATH_TO_FILE);

        DataConverter dataConverter = new DataConverterImpl();

        Map<OperationType, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(OperationType.BALANCE, new BalanceOperation());
        operationHandlers.put(OperationType.PURCHASE, new PurchaseOperation());
        operationHandlers.put(OperationType.SUPPLY, new SupplyOperation());
        operationHandlers.put(OperationType.RETURN, new ReturnOperation());
        StrategyOperationService operationStrategy = new StrategyOperationServiceImpl(
                operationHandlers);

        List<ShopOperation> operations = dataConverter.convertToOperation(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(operations);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(PATH_TO_REPORT_FILE, resultingReport);
    }
}
