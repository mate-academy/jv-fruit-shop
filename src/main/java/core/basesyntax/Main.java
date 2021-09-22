package core.basesyntax;

import core.basesyntax.activity.ActivityStrategy;
import core.basesyntax.file.CsvFileReader;
import core.basesyntax.file.CsvFileReaderImpl;
import core.basesyntax.file.FileWriter;
import core.basesyntax.file.FileWriterFileImpl;
import core.basesyntax.implementation.ActivityStrategyImpl;
import core.basesyntax.implementation.BalanceActivityHandlerImpl;
import core.basesyntax.implementation.PurchaseActivityHandlerImpl;
import core.basesyntax.implementation.ReturnActivityHandlerImpl;
import core.basesyntax.implementation.SupplyActivityHandlerImpl;
import core.basesyntax.implementation.ValidatorImpl;
import core.basesyntax.implementation.WriterServiceImpl;
import core.basesyntax.activity.Activities;
import core.basesyntax.activity.ActivityHandler;
import core.basesyntax.service.fruitService;
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
        CsvFileReader csvReader = new CsvFileReaderImpl();
        String inputData = csvReader.readFromFile(INPUT_FILE);
        RecordParser recordParser = new RecordParser();
        List<Record> recordList = recordParser.parseRecords(inputData);
        Validator validator = new ValidatorImpl();
        validator.validate(recordList);
        FileWriter fileWriter = new FileWriterFileImpl();
        WriterService writerService = new WriterServiceImpl(fileWriter, OUTPUT_FILE);
        fruitService fruiTservice =
                new fruitService(recordList, writerService, activityStrategy);
        fruiTservice.applyOperationsOnFruitsRecords();
        fruiTservice.generateReport();
    }
}
