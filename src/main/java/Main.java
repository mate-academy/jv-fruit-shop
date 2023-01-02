import java.io.File;
import java.util.List;
import java.util.Map;
import model.Fruit;
import service.Handler;
import service.Reader;
import service.Writer;
import service.impl.HandlerImpl;
import service.impl.ReaderImpl;
import service.impl.WriterImpl;

public class Main {
    public static final String FILE_NAME
            = new File("src/main/resources/Fruits.csv").getAbsolutePath();
    public static final String FILE_REPORT
            = new File("src/main/resources/report.csv").getAbsolutePath();

    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        List<Fruit> fruitsList = reader.readerData(FILE_NAME);
        Handler handler = new HandlerImpl();
        Map<String, Integer> fruitsReport = handler.processingData(fruitsList);
        Writer writer = new WriterImpl();
        writer.writeReport(fruitsReport, FILE_REPORT);
    }
}
