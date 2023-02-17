package core.basesyntax.strategy.filestrategy;

import java.util.Map;
import java.util.Optional;

public class DataParsingStrategy {
    private final Map<String, DataParser> dataParsersMap;

    public DataParsingStrategy(Map<String, DataParser> dataParsersMap) {
        this.dataParsersMap = dataParsersMap;
    }

    public DataParser getDataParser(String type) {
        Optional<DataParser> dataParserOptional = Optional.of(dataParsersMap.get(type));
        return dataParserOptional.orElseThrow(
                () -> new RuntimeException("Invalid file type " + type));
    }
}
