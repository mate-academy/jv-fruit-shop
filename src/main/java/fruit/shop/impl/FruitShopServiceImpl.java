package fruit.shop.impl;

import fruit.shop.service.ShopService;
import fruit.shop.db.Storage;
import fruit.shop.service.parser.RecordsParser;
import fruit.shop.service.saver.RecordsSaver;
import fruit.shop.service.reader.ReaderService;
import fruit.shop.service.writer.WriterService;
import java.util.List;

public class FruitShopServiceImpl implements ShopService {
    private ReaderService recordsReader;
    private RecordsParser parser;
    private WriterService writer;
    private RecordsSaver saver;

    public FruitShopServiceImpl(ReaderService recordsReader, RecordsParser parser, WriterService writer, RecordsSaver saver) {
        this.recordsReader = recordsReader;
        this.parser = parser;
        this.writer = writer;
        this.saver = saver;
    }

    @Override
    public void serveShop(String sourceFile, String destinationFile) {
        List<String> records = recordsReader.getRecords(sourceFile);
        List<String[]> list = parser.parseRecords(records);
        Storage.fruits = saver.saveRecordsToMap(list);
        writer.writeRecordsToFile(destinationFile, Storage.fruits);
    }
}
