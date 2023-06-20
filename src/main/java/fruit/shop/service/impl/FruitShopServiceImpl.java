package fruit.shop.service.impl;

import fruit.shop.model.FruitTransaction;
import fruit.shop.service.ReaderService;
import fruit.shop.service.RecordsParser;
import fruit.shop.service.ReportGenerator;
import fruit.shop.service.ShopService;
import fruit.shop.service.WriterService;
import fruit.shop.service.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements ShopService {
    private ReaderService recordsReader;
    private RecordsParser parser;
    private WriterService writer;
    private ReportGenerator connector;
    private Map<FruitTransaction.Operation, OperationHandler> handlerMap;

    public FruitShopServiceImpl(ReaderService recordsReader,
                                RecordsParser parser,
                                WriterService writer,
                                ReportGenerator connector,
                                Map<FruitTransaction.Operation,
                                        OperationHandler> handlerMap) {
        this.recordsReader = recordsReader;
        this.parser = parser;
        this.writer = writer;
        this.connector = connector;
        this.handlerMap = handlerMap;
    }

    @Override
    public void serveShop(String sourceFile, String destinationFile) {
        List<String> records = recordsReader.getRecords(sourceFile);
        List<FruitTransaction> list = parser.parseRecords(records);
        new TransactionHandlerImpl(list, handlerMap).getParsedStorage();
        writer.writeToFile(destinationFile, connector.generateReport());
    }
}
