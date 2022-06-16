package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Model;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActionsDaoImpl implements ActionsDao {
    private static final int HEAD_OF_FILE = 0;
    private Storage storage = new Storage();

    @Override
    public List<Model> getAllActions() {
        List<String> lines = storage.getAllData();
        lines.remove(HEAD_OF_FILE);
        List<Model> list = new ArrayList<>();
        String[] fields;
        for (String line : lines) {
            fields = line.split(";");
            list.add(new Model(fields[0].trim(), fields[1].trim(), Integer.parseInt(fields[2])));
        }
        return list;
    }

    @Override
    public boolean isDoneReport(Map<String, Integer> modelAmount) {
        storage.writeToFile("fruit,quantity", StandardOpenOption.TRUNCATE_EXISTING);
        String row;
        for (Map.Entry<String, Integer> entry : modelAmount.entrySet()) {
            row = System.lineSeparator() + entry.getKey() + "," + entry.getValue();
            storage.writeToFile(row, StandardOpenOption.APPEND);
        }
        return true;
    }
}
