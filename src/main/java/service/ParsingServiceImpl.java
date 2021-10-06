package service;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitRecord;

public class ParsingServiceImpl implements ParsingService {
    private Validator validator = new Validator();

    @Override
    public List<FruitRecord> parse(List<String> rawData) {
        return rawData.stream()
                .filter(s -> !s.trim().startsWith("type"))
                .map(validator::apply)
                .collect(Collectors.toList());
    }
}
