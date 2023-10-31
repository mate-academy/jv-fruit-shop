package serviceimpl;

import db.Storage;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import service.Reporter;

public class ReporterImpl implements Reporter {
    private static final String FIRST_STRING = "fruit,quantity";
    private static final Storage storage = new Storage();

    @Override
    public List<String> report() {
        Map<String, Integer> newStorage = storage.getStorage();
        List<String> dailyBalanceList =
                newStorage.entrySet()
                        .stream()
                        .map(s -> s.getKey().toLowerCase()
                                + FruitPackerImpl.COMMA
                                + s.getValue())
                        .collect(Collectors.toList());
        dailyBalanceList.add(0, FIRST_STRING);
        return dailyBalanceList;
    }
}
