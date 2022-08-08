package core.basesyntax.service.reports;

import java.util.Map;

public class ReportServiceImp implements ReportService {
    @Override
    public String create(Map<String, Integer> data) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("fruit,quantity");
        data.forEach((key, value) -> stringBuffer
                .append(System.lineSeparator()).append(key).append(",").append(value));
        return stringBuffer.toString();
    }
}
