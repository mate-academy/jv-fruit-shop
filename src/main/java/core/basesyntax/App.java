package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.CsvParserImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import java.util.List;

public class App {
    private static final String FILE_FROM = "src/main/resources/shop_activity.csv";
    private static final String FILE_TO = "src/main/resources/report.csv";

    public static void main(String[] args) {
        CsvFileReader reader = new CsvFileReaderImpl();
        List<String> dataFromFile = reader.readFromFile(FILE_FROM);
        List<String[]> parsedData = new CsvParserImpl().parse(dataFromFile);

        FruitService service = new FruitServiceImpl();
        service.processActivities(parsedData);

        CsvFileWriter writer = new CsvFileWriterImpl();
        writer.writeToFile(FILE_TO, Storage.storage);
    }
}
