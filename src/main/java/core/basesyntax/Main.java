package core.basesyntax;

import core.basesyntax.opationstrategy.OperationHandler;
import core.basesyntax.opationstrategy.OperationStrategy;
import core.basesyntax.opationstrategy.OperationStrategyImpl;
import core.basesyntax.operations.BalanceOperation;
import core.basesyntax.operations.FruitTransaction;
import core.basesyntax.operations.PurchaseOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.SupplyOperation;
import core.basesyntax.shopserviceandreportgenerator.ReportGenerator;
import core.basesyntax.shopserviceandreportgenerator.ReportGeneratorImpl;
import core.basesyntax.shopserviceandreportgenerator.ShopService;
import core.basesyntax.shopserviceandreportgenerator.ShopServiceImpl;
import core.basesyntax.workwithfile.DataConverterImpl;
import core.basesyntax.workwithfile.FileReaderImpl;
import core.basesyntax.workwithfile.FileWriterImpl;
import core.basesyntax.workwithfileinterface.DataConverter;
import core.basesyntax.workwithfileinterface.FileDataReader;
import core.basesyntax.workwithfileinterface.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileDataReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("IDontKnowFileName.csv");

        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(shopService.getStorage());

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");

        System.out.println("Report is done and written to finalReport.csv");
    }
}
