package core.basesyntax;

import core.basesyntax.handler.CsvFileProcessor;
import core.basesyntax.handler.CsvRequestHandler;
import core.basesyntax.handler.FileProcessor;
import core.basesyntax.handler.RequestHandler;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;

public class Main {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new CsvFileProcessor();
        FruitService fruitService = new FruitServiceImpl();
        RequestHandler requestHandler = new CsvRequestHandler(fileProcessor, fruitService);
        requestHandler.handle("fruits.csv");
    }
}
