package core.basesyntax.strategy.filestrategy;

import core.basesyntax.strategy.filestrategy.impl.CsvDataParserImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DataParserHandler {
    private final Map<String, DataParser> dataParsers = new HashMap<>();

    {
        dataParsers.put(FileType.CSV.getName(), new CsvDataParserImpl());
    }

    public DataParser getDataParser(String type) {
        Optional<DataParser> dataParserOptional = Optional.of(dataParsers.get(type));
        return dataParserOptional.orElseThrow(
                () -> new RuntimeException("Invalid file type " + type));
    }
}
