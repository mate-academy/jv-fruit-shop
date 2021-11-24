package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitReporter;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.strategy.ActivityStrategy;
import core.basesyntax.strategy.impl.ActivityStrategyImpl;
import java.nio.file.Paths;

public class FruitShopServiceImpl implements FruitShopService {
    private FruitReporter fruitReporter;

    public FruitShopServiceImpl() {
        fruitReporter = new FruitReporterImpl();
    }

    @Override
    public String getReport(String filePath) {
        ReaderService fileReader = new ReaderServiceImpl();
        ActivityStrategy activityStrategy = new ActivityStrategyImpl();
        fileReader
                .read(Paths.get(filePath))
                .stream()
                .forEach(a -> activityStrategy
                        .getActivity(a.getActivityType())
                        .apply(a));
        return fruitReporter.report(Storage.fruitsStorage);
    }
}
