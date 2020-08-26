package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitParser;
import core.basesyntax.service.impl.FileServiceImpl;
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
        FileService fileService = new FileServiceImpl();
        FruitParser fruitParser = new FruitParserImpl();
        List<List<String>> data = fileService.readByPattern(args[0],
                "(s|b|r),\\w+,\\d+,\\d{4}-\\d{2}-\\d{2}");

        for (List<String> row : data) {
            Fruit fruit = fruitParser.parse(row);
            shop.trade(row.get(0), fruit);
        }

        fileService.write(shop.balanceStorage(), "balance_storage_"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss")));
    }
}
