package core.basesyntax;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.io.FileReader;
import core.basesyntax.io.FileReaderImpl;
import core.basesyntax.io.FileWriter;
import core.basesyntax.io.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.OperationStrategyImpl;
import core.basesyntax.operation.PurchaseOperation;
import core.basesyntax.operation.ReturnOperation;
import core.basesyntax.operation.SupplyOperation;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_PATH = "src/main/report/reportToRead.csv";
    private static final String WRITE_PATH = "src/main/report/finalReport.csv";

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        FileWriter fileWriter = new FileWriterImpl();

        List<String> inputLines = fileReader.read(READ_PATH);
        List<FruitTransaction> transactions = dataConverter.convertToTransactions(inputLines);
        shopService.process(transactions);
        String report = reportGenerator.generateReport();
        fileWriter.write(report, WRITE_PATH);
    }
}
