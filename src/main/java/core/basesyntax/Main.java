package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.dao.ReaderServiceImpl;
import core.basesyntax.dao.Validator;
import core.basesyntax.dao.WriterServiceImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, OperationHandler> operationHandlesMap = new HashMap<>();

    public static void getReport(String fromFile, String toFile) {
        ShopServiceImpl shopService = new ShopServiceImpl(new FruitDaoImpl(),
                new FruitServiceImpl(new FruitDaoImpl()),
                new OperationStrategyImpl(operationHandlesMap));
        Validator validator = new Validator();
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        validator.checkData(fromFile);
        List<String> listOfInfo = readerService.getDataFromFile(fromFile);
        for (String infoRow:
                listOfInfo) {
            shopService.processing(infoRow);
        }

        StringBuilder stringBuilder = new StringBuilder("fruit,quantity");
        for (Fruit fruit:
                Storage.fruits) {
            stringBuilder.append("\n")
                    .append(fruit.getName())
                    .append(",")
                    .append(fruit.getQuantity());
        }
        WriterServiceImpl writerService = new WriterServiceImpl();
        writerService.writeData(toFile,stringBuilder.toString());
    }

    public static void main(String[] args) {
        String fromFile = "src/main/resources/inputFile.csv";
        String toFile = "src/main/resources/outputFile.csv";
        getReport(fromFile,toFile);
    }
}
