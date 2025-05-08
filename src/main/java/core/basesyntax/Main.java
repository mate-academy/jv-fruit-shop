package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.DataConverter;
import core.basesyntax.service.operation.DataConverterImpl;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.FruitReaderImpl;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.Writer;
import core.basesyntax.service.operation.BalanceOperation;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperation;
import core.basesyntax.service.operation.ReturnOperation;
import core.basesyntax.service.operation.SupplyOperation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String File_From = "src/main/resources/database.csv";
    public static final String File_To = "src/main/resources/ValueToFileDataBase.csv";

    public static void main(String[] args) {
        Reader fruitReader = new FruitReaderImpl();
        List<String> inputReport = fruitReader.read(File_From);

        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport();

        Writer writer = new FileWriterImpl();
        writer.write(report, File_To);
    }
}
