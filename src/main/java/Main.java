import java.util.List;
import java.util.Map;
import service.ParserService;
import service.ReaderService;
import service.WriterService;
import service.impl.ParserServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.WriterServiceImpl;

public class Main {
    public static final String FILE_INPUT_PATH = "src/main/resources/input.csv";
    public static final String FILE_OUTPUT_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> records = readerService.readFromFile(FILE_INPUT_PATH);
        Map<String, Integer> fruit = parserService.parseData(records);
        writerService.writeReport(fruit, FILE_OUTPUT_PATH);
    }

}

