package core.basesyntax.service;

import core.basesyntax.database.FruitDto;
import core.basesyntax.service.minorservices.GenerateReportService;
import core.basesyntax.service.minorservices.ReaderService;
import core.basesyntax.service.strategy.ActivityStrategy;
import core.basesyntax.validation.Validator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FruitsShopServiceImpl implements FruitsShopService {
    private static final int ACTIVITY_POSITION = 0;
    private static final int FRUIT_NAME_POSITION = 1;
    private static final int FRUIT_AMOUNT_POSITION = 2;
    private final ActivityStrategy activityStrategy;
    private final ReaderService readerService;
    private final GenerateReportService writerService;

    public FruitsShopServiceImpl(ActivityStrategy activityStrategy,
                                 ReaderService readerService, GenerateReportService writerService) {
        this.activityStrategy = activityStrategy;
        this.readerService = readerService;
        this.writerService = writerService;
    }

    @Override
    public String createReport(String filePath) {
        List<String> lines = readerService.readFromFile(filePath);
        if (!Validator.validate(lines)) {
            throw new RuntimeException("Input data isn't valid.");
        }
        Set<String> fruitNames = new HashSet<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(",");
            fruitNames.add(values[FRUIT_NAME_POSITION]);
            activityStrategy.get(values[ACTIVITY_POSITION])
                    .doActivity(new FruitDto(values[FRUIT_NAME_POSITION],
                            Integer.parseInt(values[FRUIT_AMOUNT_POSITION])));
        }
        return writerService.generateReport(fruitNames);
    }
}
