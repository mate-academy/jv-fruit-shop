package fruit.shop.service;

import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser{
    @Override
    public List<String> getOperationData(List<String> data, String type) {
        return data.stream()
                .skip(1)
                .filter(n -> n.startsWith(type))
                .collect(Collectors.toList());
    }
}
