package core.basesyntax;

import core.basesyntax.files.Reader;
import core.basesyntax.files.ReaderFile;
import core.basesyntax.files.Writer;
import core.basesyntax.files.WriterFile;
import core.basesyntax.servise.ActivityStrategy;
import core.basesyntax.servise.ActivityStrategyImpl;
import core.basesyntax.servise.ReaderService;
import core.basesyntax.servise.ReaderServiceImpl;
import core.basesyntax.servise.ShopService;
import core.basesyntax.servise.ShopServiceImpl;
import core.basesyntax.servise.WriterService;
import core.basesyntax.servise.WriterServiceImpl;
import core.basesyntax.servise.activity.ActivityHandler;
import core.basesyntax.servise.activity.BalanceActivityHandler;
import core.basesyntax.servise.activity.PurchaseActivityHandler;
import core.basesyntax.servise.activity.ReturnActivityHandler;
import core.basesyntax.servise.activity.SupplyActivityHandler;
import core.basesyntax.validation.LineValidator;
import core.basesyntax.validation.TitleValidator;
import core.basesyntax.validation.Validator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String sourceFilePath = "src/main/resources/12-09-2021.csv";
        String resultFilePath = "src/main/resources/12-09-2021result.csv";
        Map<String, ActivityHandler> activities = new HashMap<>();
        activities.put("b", new BalanceActivityHandler());
        activities.put("s", new SupplyActivityHandler());
        activities.put("p", new PurchaseActivityHandler());
        activities.put("r", new ReturnActivityHandler());
        Validator titleValidator = new TitleValidator();
        Validator lineValidator = new LineValidator();
        Reader reader = new ReaderFile(sourceFilePath);
        ReaderService readerService = new ReaderServiceImpl(reader, titleValidator, lineValidator);
        Writer writer = new WriterFile(resultFilePath);
        WriterService writerService = new WriterServiceImpl(writer);
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activities);
        ShopService shopService = new ShopServiceImpl(readerService,
                writerService, activityStrategy);
        shopService.availableFruitsAfterWorkShift();
    }
}
