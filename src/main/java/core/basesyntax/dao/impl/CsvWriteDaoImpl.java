package core.basesyntax.dao.impl;

import core.basesyntax.dao.CsvDao;
import core.basesyntax.dao.WriteDao;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriteDaoImpl extends CsvDao implements WriteDao {
    public CsvWriteDaoImpl(String destinationPath) {
        super(destinationPath);
    }

    @Override
    public void save(String contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(contentToWrite);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file by path: " + path, e);
        }
    }
}
