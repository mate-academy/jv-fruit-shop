package service.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParserToImpl implements ParserTo {
    static final String JAVA_CODE = "=";
    static final String FILE_CODE = ",";

    @Override
    public List<String> parsedListToFile(Map<String, Integer> map) {
        return new ArrayList<>(map.entrySet())
                .stream()
                .map(m -> m.toString().replace(JAVA_CODE,FILE_CODE))
                .toList();

    }
}
