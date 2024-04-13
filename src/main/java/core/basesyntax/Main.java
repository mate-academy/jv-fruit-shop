package core.basesyntax;

import core.basesyntax.servise.FruitService;
import core.basesyntax.servise.ReaderService;
import core.basesyntax.servise.WriterService;
import core.basesyntax.servise.impl.CsvFileReaderServiceImpl;
import core.basesyntax.servise.impl.CsvFileWriterServiceImpl;
import core.basesyntax.servise.impl.FruitServiceImpl;
import core.basesyntax.servise.strategy.impl.OperationStrategiesImpl;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ReaderService readerService = new CsvFileReaderServiceImpl();
        FruitService fruitService = new FruitServiceImpl(new OperationStrategiesImpl());
        WriterService writerService = new CsvFileWriterServiceImpl();

        List<String> inputData = readerService.readFromFile();
        fruitService.processingData(inputData);
        String report = fruitService.generateReport();
        writerService.writeToFile(report);
    }
}
