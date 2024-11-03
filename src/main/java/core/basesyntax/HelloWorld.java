package core.basesyntax;

import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileWriter;
import core.basesyntax.dao.impl.FileReaderImpl;
import core.basesyntax.dao.impl.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.BalanceOperation;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.PurchaseOperation;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ReturnOperation;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {

    public static void main(String[] args) {

        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.csv");

        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");

    }
}

