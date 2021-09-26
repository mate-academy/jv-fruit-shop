package service;

import dao.Reader;
import dao.ReaderImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportImpl implements Report {

    private static final String FILE_PATH = "src/main/resources/input.csv";

    @Override
    public Map<String, Integer> report() {
        Reader reader = new ReaderImpl();
        List<String> data = reader.reader(FILE_PATH);
        Map<String, Integer> fruitBalance = new HashMap<>();
        for (String element : data) {
            String[] split = element.split(",");
            if (split[0].equals("b")) {
                fruitBalance.put(split[1], Integer.parseInt(split[2]));
            }
        }

        for (String element : data) {
            String[] split = element.split(",");
            if (split[0].equals("s") || split[0].equals("r")) {
                fruitBalance.replace(split[1], fruitBalance.get(split[1])
                        + Integer.parseInt(split[2]));
            } else if (split[0].equals("p")) {
                fruitBalance.replace(split[1], fruitBalance.get(split[1])
                        - Integer.parseInt(split[2]));
            }
        }
        return fruitBalance;
    }
}
