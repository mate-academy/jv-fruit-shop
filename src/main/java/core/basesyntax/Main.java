package core.basesyntax;

import core.basesyntax.dao.DataConverter;
import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileWriter;
import core.basesyntax.dao.impl.DataConverterImpl;
import core.basesyntax.dao.impl.FileReaderImpl;
import core.basesyntax.dao.impl.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShop;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.FruitShopImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.operations.BalanceOperation;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.PurchaseOperation;
import core.basesyntax.service.operations.ReturnOperation;
import core.basesyntax.service.operations.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.csv");

        DataConverter dataConverter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        FruitShop shopService = new FruitShopImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.generateReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write("fruitReport.csv", resultingReport);
    }
}
