package core.service;

import core.service.impl.Spliterator;
import java.util.ArrayList;
import java.util.List;

public class DataSpliterator implements Spliterator<OperationData> {
    private static final String splitRegex = ",";

    @Override
    public List<OperationData> splitData(String data) {
        List<OperationData> result = new ArrayList<>();
        String[] lines = data.split("\n");

        for (String line : lines) {
            String[] parts = line.split(splitRegex);
            if (parts.length != 3) {
                continue;
            }
            try {
                int quantity = Integer.parseInt(parts[2].trim());
                result.add(new OperationData(parts[0], parts[1], quantity));
            } catch (NumberFormatException e) {
                System.err.println("Invalid quantity value: " + parts[2]);
            }
        }

        return result;
    }
}
