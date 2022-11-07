package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReadFromFile;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.WriteToFile;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParseFileImpl;
import core.basesyntax.service.impl.ReadFromFileImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationHandlerBalance;
import core.basesyntax.strategy.impl.OperationHandlerPurchase;
import core.basesyntax.strategy.impl.OperationHandlerReturn;
import core.basesyntax.strategy.impl.OperationHandlerSupply;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH_READ = "src/main/resources/inputFile.csv";
    private static final String FILE_PATH_WRITE = "src/main/resources/outputFile.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> strategies = new HashMap<>();
        strategies.put(FruitTransaction.Operation.BALANCE, new OperationHandlerBalance());
        strategies.put(FruitTransaction.Operation.SUPPLY, new OperationHandlerSupply());
        strategies.put(FruitTransaction.Operation.PURCHASE, new OperationHandlerPurchase());
        strategies.put(FruitTransaction.Operation.RETURN, new OperationHandlerReturn());

        ReadFromFile reader = new ReadFromFileImpl();
        List<String> data = reader.readFile(FILE_PATH_READ);
        List<FruitTransaction> transactions = new ParseFileImpl().parseData(data);
        OperationStrategy chooseOperation = new OperationStrategyImpl(strategies);
        FruitService fruitService = new FruitServiceImpl(chooseOperation);
        fruitService.apply(transactions);
        ReportGeneratorService report = new ReportGeneratorServiceImpl();
        String reportText = report.reportGenerate();
        WriteToFile write = new WriteToFileImpl();
        boolean writingResult = write.write(reportText, FILE_PATH_WRITE);
        System.out.println(writingResult);
    }
}
