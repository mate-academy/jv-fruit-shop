package core.basesyntax;

import core.basesyntax.servise.DataProcessorService;
import core.basesyntax.servise.FruitTransaction;
import core.basesyntax.servise.ParserService;
import core.basesyntax.servise.ReaderService;
import core.basesyntax.servise.ReportMakerService;
import core.basesyntax.servise.WriterService;
import core.basesyntax.servise.impl.CsvFileReaderServiceImpl;
import core.basesyntax.servise.impl.CsvFileWriterServiceImpl;
import core.basesyntax.servise.impl.DataProcessorServiceImpl;
import core.basesyntax.servise.impl.ParserServiceImpl;
import core.basesyntax.servise.impl.ReportMakerServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.MapOfHandlersForStrategyImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;

public class Main {
    private static final String PATH_INFILE = "src/main/resources/file.txt";
    private static final String PATH_OUTFILE = "src/main/resources/report.txt";

    public static void main(String[] args) {
        ReaderService readerService = new CsvFileReaderServiceImpl();
        OperationStrategy strategy = new OperationStrategyImpl(new MapOfHandlersForStrategyImpl());
        ParserService parsingFruits = new ParserServiceImpl();
        DataProcessorService processingFruits = new DataProcessorServiceImpl(strategy);
        ReportMakerService reportMaker = new ReportMakerServiceImpl();
        WriterService writerService = new CsvFileWriterServiceImpl();

        List<String> inputList = readerService.readFromFile(PATH_INFILE);
        List<FruitTransaction> listOfTransactions = parsingFruits.parsingData(inputList);
        processingFruits.processingData(listOfTransactions);
        String report = reportMaker.generateReport();
        writerService.writeToFile(PATH_OUTFILE, report);
    }
}

