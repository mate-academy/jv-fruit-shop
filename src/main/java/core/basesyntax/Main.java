package core.basesyntax;

import core.basesyntax.parse.DataParserImpl;
import core.basesyntax.process.ProcessDataImpl;
import core.basesyntax.readdata.DataReaderImpl;
import core.basesyntax.report.ReportDataImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.writedata.DataWritingImpl;

public class Main {
    private static ShopService shopService =
            new ShopServiceImpl(new ReportDataImpl(),
            new DataParserImpl(), new DataReaderImpl(),
            new ProcessDataImpl(), new DataWritingImpl());

    public static void main(String[] args) {
        shopService.servicing("dataOfFruitShop.csv", "reportOfFruitShop.csv");
    }

}
