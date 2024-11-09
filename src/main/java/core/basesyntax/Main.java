package core.basesyntax;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.db.ShopStorage;
import core.basesyntax.model.AbstractTransaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvReaderService;
import core.basesyntax.service.ReportGenerationService;
import core.basesyntax.service.ShopCalculationService;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.FruitReportGenerationServiceImpl;
import core.basesyntax.service.impl.FruitShopCalculationServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvReaderService<Fruit> csvReaderService = new CsvReaderServiceImpl();
        List<AbstractTransaction<Fruit>> fruitsOperations = csvReaderService.parse(
                "src" + "/main/resources/file.csv");
        ShopCalculationService<Fruit> shopCalculationService = new FruitShopCalculationServiceImpl(
                new FruitShopStorage());
        ShopStorage<Fruit> fruitStorage = shopCalculationService.calculate(fruitsOperations);
        ReportGenerationService reportGenerationService = new FruitReportGenerationServiceImpl(
                fruitStorage);
        reportGenerationService.generateReport("src/main/resources", "report.csv");
    }
}
