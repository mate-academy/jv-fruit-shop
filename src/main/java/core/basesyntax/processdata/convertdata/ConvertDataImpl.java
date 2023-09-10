package core.basesyntax.processdata.convertdata;

import java.util.List;
import java.util.stream.IntStream;

public class ConvertDataImpl implements ConvertData {
    @Override
    public List<List<String>> convertData(List<String> data) {
        return IntStream.range(1, data.size())
                        .mapToObj(data::get)
                        .map(String::trim)
                        .map(s -> List.of(s.split(",")))
                        .toList();
    }
}
