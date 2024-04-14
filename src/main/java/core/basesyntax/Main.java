package core.basesyntax;

import core.basesyntax.servise.FruitService;
import core.basesyntax.servise.ReaderService;
import core.basesyntax.servise.ReportMakerService;
import core.basesyntax.servise.WriterService;
import core.basesyntax.servise.impl.CsvFileReaderServiceImpl;
import core.basesyntax.servise.impl.CsvFileWriterServiceImpl;
import core.basesyntax.servise.impl.FruitServiceImpl;
import core.basesyntax.servise.impl.ReportMakerServiceImpl;
import core.basesyntax.servise.strategy.OperationStrategy;
import core.basesyntax.servise.strategy.impl.MapOfHandlersForStrategyImpl;
import core.basesyntax.servise.strategy.impl.OperationStrategyImpl;
import java.util.List;

public class Main {
    private static final String PATH_INFILE = "src/main/resources/file.txt";
    private static final String PATH_OUTFILE = "src/main/resources/report.txt";

    public static void main(String[] args) {
        ReaderService readerService = new CsvFileReaderServiceImpl();
        OperationStrategy strategy = new OperationStrategyImpl(new MapOfHandlersForStrategyImpl());
        FruitService fruitService = new FruitServiceImpl(strategy);
        ReportMakerService reportMaker = new ReportMakerServiceImpl();
        WriterService writerService = new CsvFileWriterServiceImpl();

        List<String> inputData = readerService.readFromFile(PATH_INFILE);
        fruitService.processData(inputData);
        String report = reportMaker.generateReport();
        writerService.writeToFile(PATH_OUTFILE, report);
    }
}
