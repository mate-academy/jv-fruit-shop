package core.basesyntax.service;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FruitFileReader reader = new FruitFileReader();
        List<Operation> operationList = reader.readOperation("src/PerfectData.csv");
        Storage storage = new Storage();
        storage.addFruits(operationList);
        File file = new File("src/InputFile.csv");
        FruitFileWriter writer = new FruitFileWriter();
        writer.writeFruits(storage.getAllInfo(), file.getName());
    }
}
