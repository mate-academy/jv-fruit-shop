package core.basesyntax;

import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // create and fill the strategy map
        //FruitService fruitService = new FruitServiceImpl(operationStrategies);
        File file = new File("src/main/resources/file.csv");
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        readerService.readCSV(file);
    }
}
