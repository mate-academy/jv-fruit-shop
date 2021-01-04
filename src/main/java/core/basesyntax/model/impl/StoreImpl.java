package core.basesyntax.model.impl;

import core.basesyntax.dao.PlantsDao;
import core.basesyntax.dao.PlantsDaoImpl;
import core.basesyntax.model.Store;
import core.basesyntax.model.objects.Plant;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.Report;
import core.basesyntax.service.StoreService;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.StoreServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.ArrayList;
import java.util.List;

public class StoreImpl<T extends Plant> implements Store {
    protected List<T> plants;
    protected StoreService storeService;
    protected PlantsDao plantsDao;

    public StoreImpl(OperationStrategy operationStrategy) {
        plants = new ArrayList<>();
        plantsDao = new PlantsDaoImpl();
        storeService = new StoreServiceImpl(plantsDao, operationStrategy);
    }

    @Override
    public void getStatistic(String fromFilePath, String toFilePath) {
        storeService.getDataFromFile(fromFilePath);
        plants = storeService.getPlantsBalance(plantsDao.getData());
        FileWriterService fileWriterService = new FileWriterServiceImpl(toFilePath);
        Report report = plants -> {
            StringBuilder result = new StringBuilder();
            result.append("fruit,quantity").append(System.lineSeparator());
            plants
                    .stream()
                    .forEach(plant -> result.append(plant.toString()));
            return result.toString();
        };
        fileWriterService.writeToFile(report.createReport(plants));
    }
}
