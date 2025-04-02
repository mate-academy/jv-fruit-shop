package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreate;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportCreateImpl implements ReportCreate {
    @Override
    public void send(String path, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file " + path, e);
        }
    }
}
