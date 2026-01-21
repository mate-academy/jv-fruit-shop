package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Converter;
import core.basesyntax.service.ConverterImpl;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.WriteReport;
import core.basesyntax.service.WriteReportImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);

        FileReader fileReader = new FileReaderImpl();
        Converter converter = new ConverterImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        WriteReport writeReport = new WriteReportImpl();

        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);

        List<String> lines = fileReader.readReport("reportToRead.csv");
        List<FruitTransaction> transactions = converter.convert(lines);

        Map<String, Integer> result = fruitShopService.process(transactions);

        String report = reportGenerator.makeReport(result);
        writeReport.writeReport(report, "finalReport.csv");
    }
}
