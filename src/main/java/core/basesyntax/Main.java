package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.ResultData;
import core.basesyntax.service.OperationDefStrategy;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.OperationDefStrategyImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHadler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.utils.DataConverter;
import core.basesyntax.utils.FileReader;
import core.basesyntax.utils.FileWriter;
import core.basesyntax.utils.ReportGenerator;
import core.basesyntax.utils.impl.DataConverterImpl;
import core.basesyntax.utils.impl.FileReaderImpl;
import core.basesyntax.utils.impl.FileWriterImpl;
import core.basesyntax.utils.impl.ReportGeneratorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] arg) {

        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("example.csv");

        Map<String, FruitTransaction.Operation> operationMap = new HashMap<>();
        operationMap.put("b", FruitTransaction.Operation.BALANCE);
        operationMap.put("s", FruitTransaction.Operation.SUPPLY);
        operationMap.put("p", FruitTransaction.Operation.PURCHASE);
        operationMap.put("r", FruitTransaction.Operation.RETURN);
        OperationDefStrategy operationDefStrategy = new OperationDefStrategyImpl(operationMap);

        DataConverter dataConverter = new DataConverterImpl(operationDefStrategy);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHadler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        ShopService shopService = new ShopServiceImpl(operationStrategy);

        List<ResultData> resultData = shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport(resultData);

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, "finalReport.csv");

    }
}

