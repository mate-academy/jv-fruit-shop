package core.basesyntax.service.serviceimpl;

import core.basesyntax.model.Record;
import core.basesyntax.service.RecordParser;
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
    public List<Record> parseRecords(List<String> records) {
        if (records.size() < 1 || !records.get(0).equals(HEADER)) {
            throw new RuntimeException("Invalid input format");
        }
        return IntStream.range(1, records.size())
                .mapToObj(records::get)
                .map(s -> {
                    if (!s.matches(ACTIVITY_RECORD_FORMAT)) {
                        throw new RuntimeException("Invalid input format");
                    }
                    String[] line = s.split(",");
                    return new Record(line[ACTIVITY_TYPE_INDEX],
                            line[FRUIT_NAME_INDEX],
                            Integer.parseInt(line[QUANTITY_INDEX]));
                })
                .collect(Collectors.toList());
    }
}
