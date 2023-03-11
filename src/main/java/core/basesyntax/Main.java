package core.basesyntax;

import core.basesyntax.bd.Storage;
import service.FileReader;
import service.FileWriter;
import service.FruitCounter;
import service.LineParser;
import service.ReportService;
import service.implement.FileReaderImpl;
import service.implement.FileWriterImpl;
import service.implement.FruitCounterImpl;
import service.implement.LineParserImpl;
import service.implement.ReportServiceImpl;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src\\main\\resources\\input.csv";
    private static final String PATH_TO_OUTPUT_FILE = "src\\main\\resources\\output.csv";

    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        LineParser parser = new LineParserImpl();
        ReportService parse = new ReportServiceImpl();
        FruitCounter counter = new FruitCounterImpl();
        FileWriter writer = new FileWriterImpl();

        counter.fruitCounter(parser.lineParcer(reader.read(PATH_TO_INPUT_FILE)));
        writer.write(parse.createReport(Storage.storage), PATH_TO_OUTPUT_FILE);
    }
}
