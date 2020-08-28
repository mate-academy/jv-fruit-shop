package core.basesyntax;

import core.basesyntax.service.FileService;
import core.basesyntax.service.MapOperations;
import core.basesyntax.service.Operational;
import core.basesyntax.service.impl.BuyOperation;
import core.basesyntax.service.impl.ConvertToFruit;
import core.basesyntax.service.impl.ConvertToFruitTransaction;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.SupplyOrReturnOperation;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        List<String[]> fileData = fileService
                .fileReader("src\\test\\java\\core\\basesyntax\\resources\\data.csv");
        ConvertToFruitTransaction converter = new ConvertToFruitTransaction();
        List<FruitTransaction> convertedData = converter.fileDataToList(fileData);

        TransactionStorage transactionStorage = new TransactionStorage();
        transactionStorage.addAll(convertedData);

        FruitStorage fruitStorage = new FruitStorage();

        MapOperations mapOperations = new MapOperations();
        mapOperations.addOperation("s", new SupplyOrReturnOperation(fruitStorage));
        mapOperations.addOperation("r", new SupplyOrReturnOperation(fruitStorage));
        mapOperations.addOperation("b", new BuyOperation(fruitStorage));

        ConvertToFruit fruitConverter = new ConvertToFruit();
        for (FruitTransaction transaction : transactionStorage.fruitTransactions) {
            Fruit fruit = fruitConverter.convert(transaction);
            Operational operator = mapOperations.getOperation(transaction.getType());
            operator.enoughFresh(fruit.getName(), fruit.getDate(), transaction.getQuantity());
            for (int i = 0; i < transaction.getQuantity(); i++) {
                operator.apply(fruit);
            }
        }
        List<String> outputData = fruitStorage.calculateStocks();
        fileService
                .fileWriter("src\\test\\java\\core\\basesyntax\\resources\\data_output.csv",
                        outputData);
    }
}
