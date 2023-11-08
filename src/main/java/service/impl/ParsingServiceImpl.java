package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitRecord;

public class ParsingServiceImpl implements ParsingService {
    public static final int ACTIVITY_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int AMOUNT_INDEX = 2;
    private final Validator validator = new Validator();

    @Override
    public List<FruitRecord> parse(List<String> rawData) {
        return rawData.stream()
                .map(s -> s.replaceAll("\\s","").split(","))
                .filter(a -> !a[ACTIVITY_INDEX].equals("type"))
                .filter(validator)
                .map(a -> new FruitRecord(a[ACTIVITY_INDEX],
                        a[FRUIT_INDEX], Integer.parseInt(a[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }
}
