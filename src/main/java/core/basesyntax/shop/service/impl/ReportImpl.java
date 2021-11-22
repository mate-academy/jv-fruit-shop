package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.service.FruitShopService;
import core.basesyntax.shop.service.Reader;
import core.basesyntax.shop.service.Report;
import core.basesyntax.shop.service.ShopDataParser;
import core.basesyntax.shop.service.Validator;
import core.basesyntax.shop.service.Writer;
import core.basesyntax.shop.strategy.FileReadStrategyImpl;
import core.basesyntax.shop.strategy.FileWriteStrategyImpl;

public class ReportImpl implements Report {
    private FruitShopService fruitShopService;
    private ShopDataParser shopDataParser;
    private Reader reader;
    private Writer writer;
    private Validator validator;

    public ReportImpl() {
        fruitShopService = new FruitShopServiceImpl();
        validator = new ValidatorImpl();
        shopDataParser = new ShopDataParserImpl();
    }

    @Override
    public boolean createReport(String fromFilename, String toFilename) {
        reader = FileReadStrategyImpl.chooseReadFileFormat(fromFilename);
        writer = FileWriteStrategyImpl.chooseWriteFileFormat(toFilename);
        String table = reader.read(fromFilename);
        if (!validator.test(table)) {
            throw new RuntimeException("Corrupted file data");
        }
        shopDataParser.distribute(table);
        return writer.write(toFilename, shopDataParser.collect(fruitShopService.getMap()));
    }
}
