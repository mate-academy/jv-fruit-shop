package fruitstore;

import java.util.List;
import java.util.Map;
import records.parser.RecordsSaver;
import records.parser.RecordsSaverCommaSeparated;
import records.reader.RecordsFileReader;
import records.reader.RecordsReader;
import records.writer.RecordsFileWriter;
import records.writer.RecordsWriter;

public class FruitShopServeImpl implements ShopServe {
    private RecordsReader recordsReader;
    private RecordsSaver saver;
    private RecordsWriter writer;

    public FruitShopServeImpl() {
        recordsReader = new RecordsFileReader();
        saver = new RecordsSaverCommaSeparated();
        writer = new RecordsFileWriter();
    }

    @Override
    public void serveShop(String sourceFile, String destinationFile) {
        List<String> records = recordsReader.getRecords(sourceFile);
        Map<String, Integer> map = saver.saveRecordsToMap(records);
        writer.writeRecords(destinationFile, map);
    }
}
