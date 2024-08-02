package core.basesyntax;

import core.basesyntax.io.CustomFileWriter;
import core.basesyntax.io.CustomFileWriterImpl;
import core.basesyntax.io.FileReader;
import core.basesyntax.io.FileReaderImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.operationstrategy.OperationStrategyImpl;
import core.basesyntax.service.BalanceOperation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataConverterImpl;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.PurchaseOperation;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ReturnOperation;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String directoryPath = "./src/main/java/core/basesyntax";
        String apth = directoryPath + "/1some.csv";
        System.out.println(apth);
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(apth);
        DataConverter dataConverter = new DataConverterImpl();
        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();

        operationHandlers.put(Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(Operation.RETURN, new ReturnOperation());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(shopService);
        String resultingReport = reportGenerator.getReport();

        CustomFileWriter fileWriter = new CustomFileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}
