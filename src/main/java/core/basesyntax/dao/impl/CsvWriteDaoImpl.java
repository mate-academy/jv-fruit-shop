package core.basesyntax.dao.impl;

import core.basesyntax.dao.CsvDao;
import core.basesyntax.dao.WriteDao;
import core.basesyntax.service.parser.WriteParser;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvWriteDaoImpl extends CsvDao implements WriteDao {
    private final WriteParser parser;

    public CsvWriteDaoImpl(String destinationPath, WriteParser parser) {
        super(destinationPath);
        this.parser = parser;
    }

    @Override
    public void save(Map<String, Integer> fruitMap) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(parser.parseProcessedData(fruitMap));
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file by path: " + path, e);
        }
    }
}
