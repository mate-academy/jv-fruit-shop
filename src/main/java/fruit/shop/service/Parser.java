package fruit.shop.service;

import java.util.List;

public interface Parser {
    List<String> getOperationData(List<String> data, String type);
}
