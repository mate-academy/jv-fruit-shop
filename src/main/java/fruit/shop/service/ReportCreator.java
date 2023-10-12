package fruit.shop.service;

import java.util.Map;

public interface ReportCreator {
    String createString(Map<String,Integer> balanceMap);
}
