package fruit.shop;

import fruit.shop.records.parser.RecordsSaver;
import fruit.shop.records.parser.RecordsSaverCommaSeparated;
import fruit.shop.records.reader.RecordsFileReader;
import fruit.shop.records.reader.RecordsReader;
import fruit.shop.records.writer.RecordsFileWriter;
import fruit.shop.records.writer.RecordsWriter;
import java.util.List;
import java.util.Map;

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
