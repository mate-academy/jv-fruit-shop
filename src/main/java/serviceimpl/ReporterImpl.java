package serviceimpl;

import db.Storage;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import service.Reporter;

public class ReporterImpl implements Reporter {
    private static final String FIRST_STRING = "fruit,quantity";

    @Override
    public List<String> report() {
        Map<String, Integer> storage = Storage.getStorage();
        List<String> dailyBalanceList =
                storage.entrySet()
                        .stream()
                        .map(s -> s.getKey().toLowerCase()
                                + FruitPackerImpl.COMMA
                                + s.getValue())
                        .collect(Collectors.toList());
        dailyBalanceList.add(0, FIRST_STRING);
        return dailyBalanceList;
    }
}
