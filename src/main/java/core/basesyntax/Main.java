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
import core.basesyntax.strategy.BalanceCalculator;
import core.basesyntax.strategy.CalculatorStrategy;
import core.basesyntax.strategy.CalculatorStrategyImpl;
import core.basesyntax.strategy.PurchaseCalculator;
import core.basesyntax.strategy.ReturnCalculator;
import core.basesyntax.strategy.SupplyCalculator;
import core.basesyntax.strategy.TypeCalculatorStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/test.csv");
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> fruits = fileReaderService.fileToStringList(file);
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        List<TypeCalculatorStrategy> fruitCalculatorStrategies = new ArrayList<>();
        fruitCalculatorStrategies.add(new BalanceCalculator());
        fruitCalculatorStrategies.add(new PurchaseCalculator());
        fruitCalculatorStrategies.add(new ReturnCalculator());
        fruitCalculatorStrategies.add(new SupplyCalculator());
        List<FruitTransaction> fruitTransactions = fruitTransactionService.makeTransaction(fruits);
        CalculatorStrategy calculatorStrategyImpl =
                new CalculatorStrategyImpl(fruitCalculatorStrategies);
        FruitCalculationService fruitCalculationService =
                new FruitCalculationServiceImpl(calculatorStrategyImpl);
        fruitCalculationService.addToStorage(fruitTransactions);
        FileWriterService fileWriterService = new FileWriterServiceImpl("src/main/resources/");
        ReportMakerService reportMakerService = new ReportMakerServiceImpl(fileWriterService);
        reportMakerService.createReport(Storage.storage);
    }
}
