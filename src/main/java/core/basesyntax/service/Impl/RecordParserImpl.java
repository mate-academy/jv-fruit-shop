package core.basesyntax.service.Impl;

import core.basesyntax.service.RecordParser;
import core.basesyntax.service.activity.Activity;
import core.basesyntax.service.activity.ActivitySupplier;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RecordParserImpl implements RecordParser {
    private static final String HEADER = "type,fruit,quantity";
    private static final String ACTIVITY_RECORD_FORMAT = "[a-z],[a-z]+,[0-9]+";
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<Activity> parseRecords(List<String> records) {
        if (records.size() < 1 || !records.get(0).equals(HEADER)) {
            throw new RuntimeException("Invalid input format");
        }
        ActivitySupplier activitySupplier = new ActivitySupplier();
        return IntStream.range(1, records.size())
                .mapToObj(records::get)
                .map(s -> {
                    if (!s.matches(ACTIVITY_RECORD_FORMAT)) {
                        throw new RuntimeException("Invalid input format");
                    }
                    String[] line = s.split(",");
                    return activitySupplier.getActivity(line[ACTIVITY_TYPE_INDEX],
                            line[FRUIT_NAME_INDEX],
                            Integer.parseInt(line[QUANTITY_INDEX]));
                    })
                .collect(Collectors.toList());
    }
}
