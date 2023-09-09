package core.basesyntax.processdata.convertdata;

import java.util.List;

public class ConvertDataImpl implements ConvertData {
    @Override
    public List<List<String>> convertData(List<String> data) {
        return data.stream()
                .filter(s -> s.charAt(0) == ' ')
                .map(String::trim)
                .map(s -> List.of(s.split(",")))
                .toList();
    }
}
