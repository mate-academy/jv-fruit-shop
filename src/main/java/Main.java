import static core.basesyntax.shop.strategy.FileReadStrategy.chooseReadFileFormat;
import static core.basesyntax.shop.strategy.FileWriteStrategy.chooseWriteFileFormat;

import core.basesyntax.shop.dao.FruitShopDaoImpl;
import core.basesyntax.shop.service.Reader;
import core.basesyntax.shop.service.ShopDataParser;
import core.basesyntax.shop.service.Validator;
import core.basesyntax.shop.service.Writer;
import core.basesyntax.shop.service.impl.FruitShopServiceImpl;
import core.basesyntax.shop.service.impl.ShopDataParserImpl;
import core.basesyntax.shop.service.impl.ValidatorImpl;

public class Main {
    public static void main(String[] args) {
        String fromFilename = "correct.csv";
        String toFilename = "output.csv";
        Reader reader = chooseReadFileFormat(fromFilename);
        Writer writer = chooseWriteFileFormat(toFilename);
        Validator validator = new ValidatorImpl();
        ShopDataParser shopDataParser = new ShopDataParserImpl(
                new FruitShopServiceImpl(new FruitShopDaoImpl()));
        String table = reader.read(fromFilename);
        validator.validate(table);
        shopDataParser.distribute(table);
        writer.write(toFilename, shopDataParser.collect());
    }
}
