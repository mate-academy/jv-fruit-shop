package fruitshop;

import fruitshop.service.FruitService;
import fruitshop.service.OperationStrategy;
import fruitshop.service.ReaderService;
import fruitshop.service.WriterService;
import fruitshop.service.impl.FruitServiceImpl;
import fruitshop.service.impl.OperationStrategyImpl;
import fruitshop.service.impl.ReaderServiceImpl;
import fruitshop.service.impl.WriterServiceImpl;

public class Main {
    public static final String INPUT_FILE = "src/main/resources/input.txt";
    public static final String OUTPUT_FILE = "src/main/resources/output.txt";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        WriterService writerService = new WriterServiceImpl();
        FruitService fruitService = new FruitServiceImpl(readerService,
                writerService, operationStrategy);
        fruitService.makeReportAtTheEndOfTheDay(INPUT_FILE, OUTPUT_FILE);
    }
}
