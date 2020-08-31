package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitMapper;
import core.basesyntax.service.ReportBuilder;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitMapperImpl;
import core.basesyntax.service.impl.ReportBuilderImpl;
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
        Storage storage = new Storage();
        Map<String, Trading> tradingMap = new HashMap<>();
        tradingMap.put("s", new SupplyTradingImpl(storage));
        tradingMap.put("b", new BuyTradingImpl(storage));
        tradingMap.put("r", new RefundsTradingImpl(storage));
        Shop shop = new Shop(tradingMap, storage);

        FileReaderService fileReader = new FileReaderServiceImpl();
        List<FruitDto> data = fileReader.read("input.csv");

        FruitMapper fruitParser = new FruitMapperImpl();

        ShopService shopService = new ShopService(shop, fruitParser);
        shopService.precessWaybill(data);

        FileWriterService fileWriter = new FileWriterServiceImpl();
        String fileName = "balance_storage_"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss"))
                + ".csv";
        ReportBuilder reportBuilder = new ReportBuilderImpl();
        Map<String, Integer> report = reportBuilder.buildReport(shop.balanceStorage());
        fileWriter.write(report, fileName);
    }
}
