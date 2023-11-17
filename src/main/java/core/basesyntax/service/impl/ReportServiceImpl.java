package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {

    @Override
    public String prepareReport(Map<String, Integer> reportMap) {

        StringBuilder sb = new StringBuilder();
        sb.append("fruit,quantity");
        sb.append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : reportMap.entrySet()) {
            sb.append(entry.getKey()).append(",").append(entry.getValue());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
