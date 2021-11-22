package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.service.ParseShopData;
import core.basesyntax.shop.service.ReadFromFile;
import core.basesyntax.shop.service.ShopService;
import core.basesyntax.shop.service.Validator;
import core.basesyntax.shop.service.WriteToFile;
import core.basesyntax.shop.strategy.FileReadStrategy;
import core.basesyntax.shop.strategy.FileWriteStrategy;

public class Report {
    private ShopService shopService;
    private ParseShopData parseShopData;
    private ReadFromFile readFromFile;
    private WriteToFile writeToFile;
    private Validator validator;

    public Report() {
        shopService = new ShopServiceImpl();
        validator = new ValidatorImpl();
        parseShopData = new ParseShopDataImpl();
    }

    public boolean createReport(String fromFilename, String toFilename) {
        readFromFile = FileReadStrategy.chooseReadFileFormat(fromFilename);
        writeToFile = FileWriteStrategy.chooseWriteFileFormat(toFilename);
        String table = readFromFile.read(fromFilename).toLowerCase();
        if (!validator.test(table)) {
            throw new RuntimeException("Corrupted file data");
        }
        parseShopData.distribute(table);
        return writeToFile.write(toFilename, parseShopData.collect(shopService.getMap()));
    }
}
