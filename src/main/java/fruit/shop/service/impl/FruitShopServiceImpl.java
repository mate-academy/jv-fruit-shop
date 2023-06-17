package fruit.shop.service.impl;

import fruit.shop.db.Storage;
import fruit.shop.model.FruitTransaction;
import fruit.shop.service.ReaderService;
import fruit.shop.service.RecordsParser;
import fruit.shop.service.ShopService;
import fruit.shop.service.WriterService;
import fruit.shop.service.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements ShopService {
    private ReaderService recordsReader;
    private RecordsParser parser;
    private WriterService writer;
    private Map<FruitTransaction.Operation, OperationHandler> fruitMap;

    public FruitShopServiceImpl(ReaderService recordsReader, RecordsParser parser,
                                WriterService writer,
                                Map<FruitTransaction.Operation, OperationHandler> fruitMap) {
        this.recordsReader = recordsReader;
        this.parser = parser;
        this.writer = writer;
        this.fruitMap = fruitMap;
    }

    @Override
    public void serveShop(String sourceFile, String destinationFile) {
        List<String> records = recordsReader.getRecords(sourceFile);
        List<FruitTransaction> list = parser.parseRecords(records);
        new TransactionParserImpl(list, fruitMap).getParsedStorage();
        writer.writeRecordsToFile(destinationFile, Storage.FRUITS);
    }
}
