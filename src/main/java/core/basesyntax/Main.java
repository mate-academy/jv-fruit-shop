package core.basesyntax;

import core.basesyntax.fao.FileReaderImpl;
import core.basesyntax.fao.FileReaderMy;
import core.basesyntax.fao.FileWriterImps;
import core.basesyntax.fao.FileWriterMy;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.ReportGenerator;
import core.basesyntax.model.ReportGeneratorImpl;
import core.basesyntax.model.convertor.DataConvertor;
import core.basesyntax.model.convertor.DataConvertorImpl;
import core.basesyntax.model.handler.BalanceOperation;
import core.basesyntax.model.handler.OperationHandler;
import core.basesyntax.model.handler.PurchaseOperation;
import core.basesyntax.model.handler.ReturnOperation;
import core.basesyntax.model.handler.SupplyOperation;
import core.basesyntax.model.strategy.OperationStrategy;
import core.basesyntax.model.strategy.OperationStrategyImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReaderMy fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.csv");

        DataConvertor dataConverter = new DataConvertorImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        Map<String, Integer> storage = shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(storage);

        FileWriterMy fileWriter = new FileWriterImps();
        fileWriter.write("finalReport.csv",resultingReport);
    }

}
