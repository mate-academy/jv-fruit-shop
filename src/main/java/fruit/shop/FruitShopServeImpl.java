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
    public void serveShop(String sourceFile, String destinationFile) {
        RecordsReader recordsReader = new RecordsFileReader();
        RecordsSaver saver = new RecordsSaverCommaSeparated();
        RecordsWriter writer = new RecordsFileWriter();
        List<String> records = recordsReader.getRecords(sourceFile);
        Map<String, Integer> map = saver.saveRecordsToMap(records);
        writer.writeRecords(destinationFile, map);
    }
}
