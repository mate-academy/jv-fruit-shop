import fruit.shop.impl.FruitShopServiceImpl;
import fruit.shop.service.ShopService;
import fruit.shop.service.parser.RecordsParser;
import fruit.shop.impl.RecordsParserCommaSeparated;
import fruit.shop.service.saver.RecordsSaver;
import fruit.shop.impl.RecordsSaverImpl;
import fruit.shop.impl.ReaderServiceImpl;
import fruit.shop.service.reader.ReaderService;
import fruit.shop.impl.WriterServiceImpl;
import fruit.shop.service.writer.WriterService;

public class Main {
    private static final String EXAMPLE_PATH_FROM = "src/main/resources/test1";
    private static final String EXAMPLE_PATH_TO = "src/main/resources/test2";



    public static void main(String[] args) {
        ReaderService recordsReader = new ReaderServiceImpl();
        RecordsParser parser = new RecordsParserCommaSeparated();
        WriterService writer = new WriterServiceImpl();
        RecordsSaver saver = new RecordsSaverImpl();
        ShopService fruitShop = new FruitShopServiceImpl(recordsReader, parser, writer, saver);
        fruitShop.serveShop(EXAMPLE_PATH_FROM, EXAMPLE_PATH_TO);
    }
}
