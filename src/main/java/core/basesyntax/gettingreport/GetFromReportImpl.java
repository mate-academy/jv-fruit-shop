package core.basesyntax.gettingreport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetFromReportImpl implements GetFromReport {
    @Override
    public List<String> getFromReport(String fromFile) {
        List<String> result = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFile))) {
            String value = reader.readLine();
            value = reader.readLine();
            while (value != null) {
                String line = stringBuilder.append(value).toString();
                result.add(line);
                stringBuilder.setLength(0);
                value = reader.readLine();
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file" + e);
        }
    }
}

