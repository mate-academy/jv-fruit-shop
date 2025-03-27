package core.basesyntax;

import core.basesyntax.dao.DataConverter;
import core.basesyntax.dao.DataConverterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.report.FileReaderCustom;
import core.basesyntax.report.FileReaderImpl;
import core.basesyntax.report.FileWriterCustom;
import core.basesyntax.report.FileWriterImpl;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_READ = "src/main/resources/reportToRead.csv";
    private static final String FILE_WRITE = "src/main/resources/reportFinal.csv";

    public static void main(String[] args) throws IOException {
        FileReaderCustom fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(FILE_READ);

        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(Operation.RETURN, new ReturnOperationHandler());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        ShopServiceImpl shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(shopService.getFruitStorage());

        FileWriterCustom fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, FILE_WRITE);
    }
}
