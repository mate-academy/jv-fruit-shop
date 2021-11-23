package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Activity;
import core.basesyntax.service.FruitReporter;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.strategy.impl.ActivityStrategyImpl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {


    @Override
    public String getReport(String filePath) {
        ReaderService fileReader = new ReaderServiceImpl();
        List<Activity> fileData = fileReader.read(Paths.get(filePath));
        fileData
                .stream()
                .forEach(a -> new ActivityStrategyImpl()
                        .getActivity(a.getActivityType())
                        .apply(a));
        FruitReporter fruitReporter = new FruitReporterImpl();
        return fruitReporter.report(Storage.fruitsStorage);
    }
}
