package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ActivitiesDaoImpl implements ActivitiesDao {
    @Override
    public void write(String report, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Сan't write to this file properly.", e);
        }
    }
}
