package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitParser;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitParserImpl;
import core.basesyntax.shop.Shop;
import core.basesyntax.shop.Trading;
import core.basesyntax.shop.impl.BuyTradingImpl;
import core.basesyntax.shop.impl.RefundsTradingImpl;
import core.basesyntax.shop.impl.SupplyTradingImpl;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Trading> tradingMap = new HashMap<>();
        tradingMap.put("s", new SupplyTradingImpl());
        tradingMap.put("b", new BuyTradingImpl());
        tradingMap.put("r", new RefundsTradingImpl());

        Shop shop = new Shop(tradingMap);
        FileReaderService fileReader = new FileReaderServiceImpl();
        FruitParser fruitParser = new FruitParserImpl();
        List<List<String>> data = fileReader.read("input.csv");

        for (List<String> row : data) {
            Fruit fruit = fruitParser.parse(row);
            shop.trade(row.get(0), fruit);
        }

        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.write(shop.balanceStorage(), "balance_storage_"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss"))
                + ".csv");
    }
}
