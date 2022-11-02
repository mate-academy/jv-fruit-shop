package Implementation;

import Service.ReportService;

import java.util.Iterator;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
private static final String COMMA = ",";
    @Override
    public String writeReport(Map<String, Integer> fruits) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity").append("\n");

        for(Map.Entry<String,Integer> fruit:fruits.entrySet()){
            builder.append(fruit.getKey()).append(COMMA).append(fruit.getValue()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
