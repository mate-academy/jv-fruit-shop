package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConvertor;
import core.basesyntax.service.FileContentGenerator;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitDataCounter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.DataConvertorImpl;
import core.basesyntax.service.impl.FileContentGeneratorImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitDataCounterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.QuantityCalculationStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static final String inputFile = "src/main/resources/input.csv";
    static final String outputFile = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, QuantityCalculationStrategy> strategyMap = new HashMap<>();
        strategyMap.put(FruitTransaction.Operation.BALANCE, new BalanceStrategy());
        strategyMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseStrategy());
        strategyMap.put(FruitTransaction.Operation.RETURN, new ReturnStrategy());
        strategyMap.put(FruitTransaction.Operation.SUPPLY, new SupplyStrategy());

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> lines = fileReaderService.lines(inputFile);

        DataConvertor dataConvertor = new DataConvertorImpl();
        List<FruitTransaction> fruitTransactions = dataConvertor.dataConvert(lines);

        FruitDataCounter fruitDataCounter = new FruitDataCounterImpl(strategyMap);
        fruitDataCounter.fruitsCounter(fruitTransactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        reportGenerator.reportGenerate();

        FileContentGenerator fileContentGenerator = new FileContentGeneratorImpl();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.fileWriterCsv(outputFile, fileContentGenerator.contentGen());
    }
}

