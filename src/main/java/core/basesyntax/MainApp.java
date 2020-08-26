package core.basesyntax;

import core.basesyntax.filereader.FileReaderService;
import core.basesyntax.filereader.LocalFileReaderService;
import core.basesyntax.filewriter.FileWriterServise;
import core.basesyntax.filewriter.LocalFileWriterService;
import core.basesyntax.fruitstoreoperation.BuyFruitOperation;
import core.basesyntax.fruitstoreoperation.FruitStoreOperation;
import core.basesyntax.fruitstoreoperation.SupplyFruitOperation;
import core.basesyntax.parser.Parser;
import core.basesyntax.parser.ProductParser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApp {
    private static Map<String, FruitStoreOperation> fruitStoreOperationMap = new HashMap<>();

    static {
        fruitStoreOperationMap.put("s", new SupplyFruitOperation());
        fruitStoreOperationMap.put("b", new BuyFruitOperation());
        fruitStoreOperationMap.put("r", new SupplyFruitOperation());
    }

    public static void main(String[] args) {
        OperationStrategy strategy = new OperationStrategy(fruitStoreOperationMap);
        FileReaderService readerService = new LocalFileReaderService();
        List<List<String>> toDoList = readerService.readFile(args[0]);
        toDoList.remove(0);
        InputDataModel inputModel;
        int amount;
        Parser<InputDataModel> parser = new ProductParser();
        for (List<String> operation : toDoList) {
            inputModel = parser.parse(operation);
            amount = Integer.parseInt(operation.get(2));
            FruitStoreOperation fruitStoreOperation = strategy.choseOperation(operation.get(0));
            fruitStoreOperation.doOperation(inputModel, amount);
        }
        FileWriterServise fileWriterServise = new LocalFileWriterService();
        fileWriterServise.writeFile(args[1]);
    }
}
