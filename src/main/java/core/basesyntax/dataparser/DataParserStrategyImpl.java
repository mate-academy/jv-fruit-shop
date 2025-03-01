package core.basesyntax.dataparser;

import java.util.HashMap;
import java.util.Map;

public class DataParserStrategyImpl implements DataParserStrategy {
    private final Map<ParserModels, DataParser> dataParserMap;

    public DataParserStrategyImpl() {
        dataParserMap = new HashMap<>();
        dataParserMap.put(ParserModels.CSV, new CsvDataParser());
        dataParserMap.put(ParserModels.JSON, null);
        dataParserMap.put(ParserModels.XML, null);
    }

    @Override
    public DataParser getDataParser(ParserModels model) {
        return dataParserMap.get(model);
    }
}
