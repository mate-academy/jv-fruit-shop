package core.basesyntax.service;

import core.basesyntax.service.minorservices.ReaderService;
import core.basesyntax.service.minorservices.WriterService;
import core.basesyntax.service.strategy.ActivityStrategy;
import core.basesyntax.validation.Validator;
import java.util.List;

public class FruitsShopServiceImpl implements FruitsShopService {
    private static final int ACTIVITY_POSITION = 0;
    private static final int FRUIT_NAME_POSITION = 1;
    private static final int FRUIT_AMOUNT_POSITION = 2;
    private final ActivityStrategy activityStrategy;
    private final ReaderService readerService;
    private final WriterService writerService;

    public FruitsShopServiceImpl(ActivityStrategy activityStrategy,
                                 ReaderService readerService, WriterService writerService) {
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
        for (int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(",");
            activityStrategy.get(values[ACTIVITY_POSITION])
                    .doActivity(new String[]{values[FRUIT_NAME_POSITION],
                            values[FRUIT_AMOUNT_POSITION]});
        }
        return writerService.writeReport();
    }
}
