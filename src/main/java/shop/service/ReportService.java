package shop.service;

import java.util.ArrayList;
import java.util.List;
import shop.dao.FruitDao;

public class ReportService {
    private static final String FRUIT_HEADER = "fruit";
    private static final String QUANTITY_HEADER = "quantity";
    private static final FruitDao dao = new FruitDao();

    public List<String[]> createReport() {
        List<String[]> result = new ArrayList<>();

        String[] headers = {FRUIT_HEADER, QUANTITY_HEADER};
        result.add(headers);

        List<String[]> records = dao.getBalance()
                .entrySet().stream()
                .map(e -> new String[]{e.getKey(), e.getValue().toString()})
                .toList();

        result.addAll(records);
        return result;
    }
}
