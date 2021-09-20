package core.basesyntax;

import core.basesyntax.files.Reader;
import core.basesyntax.files.ReaderFileImpl;
import core.basesyntax.files.Writer;
import core.basesyntax.files.WriterFileImpl;
import core.basesyntax.lib.ActivitiesEnum;
import core.basesyntax.servise.ActivityStrategy;
import core.basesyntax.servise.ActivityStrategyImpl;
import core.basesyntax.servise.ReaderService;
import core.basesyntax.servise.ReaderServiceImpl;
import core.basesyntax.servise.ShopService;
import core.basesyntax.servise.ShopServiceImpl;
import core.basesyntax.servise.WriterService;
import core.basesyntax.servise.WriterServiceImpl;
import core.basesyntax.servise.activity.ActivityHandler;
import core.basesyntax.servise.activity.BalanceActivityHandlerImpl;
import core.basesyntax.servise.activity.PurchaseActivityHandlerImpl;
import core.basesyntax.servise.activity.ReturnActivityHandlerImpl;
import core.basesyntax.servise.activity.SupplyActivityHandlerImpl;
import core.basesyntax.validation.LineValidator;
import core.basesyntax.validation.TitleValidator;
import core.basesyntax.validation.Validator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE = "src/main/resources/12-09-2021.csv";
    private static final String RESULT_FILE = "src/main/resources/12-09-2021result.csv";

    public static void main(String[] args) {
        Map<String, ActivityHandler> activities = new HashMap<>();
        activities.put(ActivitiesEnum.BALANCE.getActivity(), new BalanceActivityHandlerImpl());
        activities.put(ActivitiesEnum.SUPPLY.getActivity(), new SupplyActivityHandlerImpl());
        activities.put(ActivitiesEnum.PURCHASE.getActivity(), new PurchaseActivityHandlerImpl());
        activities.put(ActivitiesEnum.RETURN.getActivity(), new ReturnActivityHandlerImpl());
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activities);
        Validator titleValidator = new TitleValidator();
        Validator lineValidator = new LineValidator();
        Reader reader = new ReaderFileImpl(SOURCE_FILE);
        ReaderService readerService = new ReaderServiceImpl(reader, titleValidator, lineValidator);
        Writer writer = new WriterFileImpl(RESULT_FILE);
        WriterService writerService = new WriterServiceImpl(writer);
        ShopService shopService = new ShopServiceImpl(readerService,
                writerService, activityStrategy);
        shopService.availableFruitsAfterWorkShift();
    }
}
