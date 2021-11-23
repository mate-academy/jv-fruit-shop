package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.service.Reader;
import core.basesyntax.shop.service.ReportCreator;
import core.basesyntax.shop.service.ShopDataParser;
import core.basesyntax.shop.service.Validator;
import core.basesyntax.shop.service.Writer;
import core.basesyntax.shop.strategy.FileReadStrategy;
import core.basesyntax.shop.strategy.FileWriteStrategy;

public class ReportCreatorImpl implements ReportCreator {
    private ShopDataParser shopDataParser;
    private Reader reader;
    private Writer writer;
    private Validator validator;

    public ReportCreatorImpl(Validator validator, ShopDataParser shopDataParser) {
        this.validator = validator;
        this.shopDataParser = shopDataParser;
    }

    @Override
    public boolean createReport(String fromFilename, String toFilename) {
        reader = FileReadStrategy.chooseReadFileFormat(fromFilename);
        writer = FileWriteStrategy.chooseWriteFileFormat(toFilename);
        String table = reader.read(fromFilename);
        if (!validator.test(table)) {
            throw new RuntimeException("Corrupted file data");
        }
        shopDataParser.distribute(table);
        return writer.write(toFilename, shopDataParser.collect());
    }
}
