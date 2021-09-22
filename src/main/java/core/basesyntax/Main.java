package core.basesyntax;

import core.basesyntax.activity.ActivityStrategy;
import core.basesyntax.file.ReadFromCsvFile;
import core.basesyntax.file.ReadFromCsvFileImpl;
import core.basesyntax.file.Writer;
import core.basesyntax.file.WriterFileImpl;
import core.basesyntax.implementation.ActivityStrategyImpl;
import core.basesyntax.implementation.BalanceActivityHandlerImpl;
import core.basesyntax.implementation.PurchaseActivityHandlerImpl;
import core.basesyntax.implementation.ReturnActivityHandlerImpl;
import core.basesyntax.implementation.SupplyActivityHandlerImpl;
import core.basesyntax.implementation.ValidatorImpl;
import core.basesyntax.implementation.WriterServiceImpl;
import core.basesyntax.activity.Activities;
import core.basesyntax.activity.ActivityHandler;
import core.basesyntax.service.CalculateFruits;
import core.basesyntax.service.Validator;
import core.basesyntax.service.WriterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/input.txt";
    private static final String OUTPUT_FILE = "src/main/output.txt";

    public static void main(String[] args) {
        Map<String, ActivityHandler> activities = new HashMap<>();
        activities.put(Activities.BALANCE.getActivity(), new BalanceActivityHandlerImpl());
        activities.put(Activities.SUPPLY.getActivity(), new SupplyActivityHandlerImpl());
        activities.put(Activities.PURCHASE.getActivity(), new PurchaseActivityHandlerImpl());
        activities.put(Activities.RETURN.getActivity(), new ReturnActivityHandlerImpl());
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activities);
        ReadFromCsvFile csvReader = new ReadFromCsvFileImpl();
        String inputData = csvReader.readFromFile(INPUT_FILE);
        RecordParser recordParser = new RecordParser();
        List<Record> recordList = recordParser.parseRecords(inputData);
        Validator validator = new ValidatorImpl();
        validator.validateData(recordList);
        Writer writer = new WriterFileImpl(OUTPUT_FILE);
        WriterService writerService = new WriterServiceImpl(writer);
        CalculateFruits calculateFruits =
                new CalculateFruits(recordList, writerService, activityStrategy);
        calculateFruits.fruitsAmountAfterWorkDay();
    }
}
