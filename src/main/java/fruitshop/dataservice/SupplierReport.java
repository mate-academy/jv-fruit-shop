package fruitshop.dataservice;

import fruitshop.database.Storage;
import fruitshop.model.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SupplierReport implements WorkWithReport {
    private static final String COLUMN_NAMES = "fruit,quantity";

    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();
        report.add(COLUMN_NAMES);
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            builder.append(entry.getKey().getNameFruit()).append(",").append(entry.getValue());
            report.add(builder.toString());
            builder.setLength(0);
        }
        return report;
    }
}
