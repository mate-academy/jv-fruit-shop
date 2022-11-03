package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseFile;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.WriteToFile;
import core.basesyntax.service.impl.ParseFileImpl;
import core.basesyntax.service.impl.ReadFromFileImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.OperationHandlerBalance;
import core.basesyntax.strategy.impl.OperationHandlerPurchase;
import core.basesyntax.strategy.impl.OperationHandlerReturn;
import core.basesyntax.strategy.impl.OperationHandlerSupply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH_READ = "src/main/java/core/"
            + "basesyntax/resources/inputFile.csv";
    private static final String FILE_PATH_WRITE = "src/main/java/core"
            + "/basesyntax/resources/outputFile.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> strategies = new HashMap<>();
        strategies.put(FruitTransaction.Operation.BALANCE, new OperationHandlerBalance());
        strategies.put(FruitTransaction.Operation.SUPPLY, new OperationHandlerSupply());
        strategies.put(FruitTransaction.Operation.PURCHASE, new OperationHandlerPurchase());
        strategies.put(FruitTransaction.Operation.RETURN, new OperationHandlerReturn());

        List<String> dataFromFile = new ReadFromFileImpl().readFile(FILE_PATH_READ);
        ParseFile parse = new ParseFileImpl();
        ReportGeneratorService reportGenerator = new ReportGeneratorServiceImpl();
        String report = reportGenerator.reportGenerate();
        WriteToFile writer = new WriteToFileImpl();
        String result = writer.write(report, FILE_PATH_WRITE);
        System.out.println(result);
    }
}
