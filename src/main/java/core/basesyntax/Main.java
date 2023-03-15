package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitCalculationService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitCalculationServiceImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.strategy.CalculatorStrategy;
import core.basesyntax.strategy.TypeCalculatorStrategy;
import core.basesyntax.strategy.impl.BalanceCalculatorImpl;
import core.basesyntax.strategy.impl.CalculatorStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseCalculatorImpl;
import core.basesyntax.strategy.impl.ReturnCalculatorImpl;
import core.basesyntax.strategy.impl.SupplyCalculatorImpl;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String INPUT = "src/main/resources/test.csv";
    private static final String path = "src/main/resources/";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> fruits = fileReaderService.readToList(INPUT);
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        List<TypeCalculatorStrategy> fruitCalculatorStrategies = new ArrayList<>();
        fruitCalculatorStrategies.add(new BalanceCalculatorImpl());
        fruitCalculatorStrategies.add(new PurchaseCalculatorImpl());
        fruitCalculatorStrategies.add(new ReturnCalculatorImpl());
        fruitCalculatorStrategies.add(new SupplyCalculatorImpl());
        List<FruitTransaction> fruitTransactions =
                fruitTransactionService.createFruitTransactions(fruits);
        CalculatorStrategy calculatorStrategyImpl =
                new CalculatorStrategyImpl(fruitCalculatorStrategies);
        FruitCalculationService fruitCalculationService =
                new FruitCalculationServiceImpl(calculatorStrategyImpl);
        fruitCalculationService.addToStorage(fruitTransactions);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        ReportMakerService reportMakerService = new ReportMakerServiceImpl(fileWriterService);
        reportMakerService.createReport(Storage.storage, path);
    }
}
