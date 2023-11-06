package core.basesyntax.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class MapWriteToFileImpl implements MapWriteToFile {
    private static final String HEAD_OF_REPORT = "fruit,quantity";

    @Override
    public void mapWriteToFile(Map<String, Integer> map, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(HEAD_OF_REPORT);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                bufferedWriter.write("\n" + entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
