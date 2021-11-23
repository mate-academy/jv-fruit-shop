import core.basesyntax.shop.service.ReportCreator;
import core.basesyntax.shop.service.impl.FruitShopServiceImpl;
import core.basesyntax.shop.service.impl.ReportCreatorImpl;
import core.basesyntax.shop.service.impl.ShopDataParserImpl;
import core.basesyntax.shop.service.impl.ValidatorImpl;

public class Main {
    public static void main(String[] args) {
        ReportCreator reportCreator = new ReportCreatorImpl(new ValidatorImpl(),
                new ShopDataParserImpl(new FruitShopServiceImpl()));
        reportCreator.createReport("correct.csv", "output.csv");
        reportCreator.createReport("emptyLineBottom.csv", "output.csv");
        reportCreator.createReport("corrupted.csv", "output.csv");
        reportCreator.createReport("balanceLessThanReturn.csv", "output.csv");
        reportCreator.createReport("purchaseMoreThanBalance.csv", "output.csv");
        reportCreator.createReport("balance_2_times.csv", "output.csv");
        reportCreator.createReport("invalid.csv", "output.csv");
        reportCreator.createReport("correct.txt", "output.csv");
    }
}
