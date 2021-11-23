package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Activity;
import core.basesyntax.service.FruitReporter;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.strategy.impl.ActivityStrategyImpl;
import java.nio.file.Paths;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private FruitReporter fruitReporter;

    public FruitShopServiceImpl() {
        fruitReporter = new FruitReporterImpl();
    }

    @Override
    public String getReport(String filePath) {
        ReaderService fileReader = new ReaderServiceImpl();
        List<Activity> fileData = fileReader.read(Paths.get(filePath));
        fileData.stream()
                .forEach(a -> new ActivityStrategyImpl()
                        .getActivity(a.getActivityType())
                        .apply(a));
        return fruitReporter.report(Storage.fruitsStorage);
    }
}
