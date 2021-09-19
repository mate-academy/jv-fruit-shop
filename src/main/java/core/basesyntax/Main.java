package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.fileReader.ReadFromFile;
import core.basesyntax.fileReader.ReadFromFileImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitsService;
import core.basesyntax.service.operationTypes.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String FROM_FILE_NAME = "fruitsData.csv";
    public static void main(String[] args) {
        Map<Operations, OperationTypeHandler> strategy = new HashMap<>();
        strategy.put(Operations.r, new ReturnOperationHandler());

        ReadFromFile readFromFile = new ReadFromFileImpl();
        List<String> dataFromFile = readFromFile.read(FROM_FILE_NAME);
    }
}
