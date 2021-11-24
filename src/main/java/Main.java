import static core.basesyntax.shop.strategy.FileReadStrategy.chooseReadFileFormat;
import static core.basesyntax.shop.strategy.FileWriteStrategy.chooseWriteFileFormat;

import core.basesyntax.shop.dao.FruitShopDao;
import core.basesyntax.shop.dao.FruitShopDaoImpl;
import core.basesyntax.shop.service.Reader;
import core.basesyntax.shop.service.ReportService;
import core.basesyntax.shop.service.ShopDataParser;
import core.basesyntax.shop.service.Validator;
import core.basesyntax.shop.service.Writer;
import core.basesyntax.shop.service.impl.ReportServiceImpl;
import core.basesyntax.shop.service.impl.ShopDataParserImpl;
import core.basesyntax.shop.service.impl.ValidatorImpl;
import core.basesyntax.shop.strategy.FruitShopStrategyImpl;

public class Main {
    public static void main(String[] args) {
        String fromFileName = "correct.csv";
        String toFileName = "output.csv";
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        Reader reader = chooseReadFileFormat(fromFileName);
        Writer writer = chooseWriteFileFormat(toFileName);
        Validator validator = new ValidatorImpl();
        ShopDataParser shopDataParser = new ShopDataParserImpl(
                new FruitShopStrategyImpl(), fruitShopDao);
        ReportService reportService = new ReportServiceImpl(fruitShopDao);
        String table = reader.read(fromFileName);
        validator.validate(table);
        shopDataParser.distribute(table);
        writer.write(toFileName, reportService.collect());
    }
}
