package dataparser;

import java.util.LinkedList;
import java.util.List;

public class CsvDataParser implements DataParser {
    @Override
    public List<String[]> parseData(List<String> srcContents) {
        return new LinkedList<String[]>(srcContents.stream().map(s -> s.split(","))
                .toList());
    }
}
