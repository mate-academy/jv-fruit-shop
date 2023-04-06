package core.basesyntax;

import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;

import java.util.List;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    public static final String REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        System.out.println("Hi !!!!");
        ReaderService readerService = new ReaderServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> linesFromFile = readerService.readFromFile(INPUT_FILE);


        writerService.writeToFile(linesFromFile, REPORT_FILE);
    }
}
