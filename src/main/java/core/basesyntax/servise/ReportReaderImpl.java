package core.basesyntax.servise;

import core.basesyntax.servise.inrterfase.ReportReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReportReaderImpl implements ReportReader {
    @Override
    public List<String> readFile(String fileName) {
        File file = new File(fileName);
        List<String> report = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                report.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return report;
    }
}
