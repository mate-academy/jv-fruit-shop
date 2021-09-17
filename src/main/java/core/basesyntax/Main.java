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
    private static final String SOURCE_FILE = "src/main/resources/12-09-2021.csv";
    private static final String RESULT_FILE = "src/main/resources/12-09-2021result.csv";

    public static void main(String[] args) {
        Map<String, ActivityHandler> activities = new HashMap<>();
        activities.put(Activities.BALANCE.getActivity(), new BalanceActivityHandler());
        activities.put(Activities.SUPPLY.getActivity(), new SupplyActivityHandler());
        activities.put(Activities.PURCHASE.getActivity(), new PurchaseActivityHandler());
        activities.put(Activities.RETURN.getActivity(), new ReturnActivityHandler());
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activities);
        Validator titleValidator = new TitleValidator();
        Validator lineValidator = new LineValidator();
        Reader reader = new ReaderFile(SOURCE_FILE);
        ReaderService readerService = new ReaderServiceImpl(reader, titleValidator, lineValidator);
        Writer writer = new WriterFile(RESULT_FILE);
        WriterService writerService = new WriterServiceImpl(writer);
        ShopService shopService = new ShopServiceImpl(readerService,
                writerService, activityStrategy);
        shopService.availableFruitsAfterWorkShift();
    }

    enum Activities {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String activity;

        Activities(String activity) {
            this.activity = activity;
        }

        public String getActivity() {
            return activity;
        }
    }
}
