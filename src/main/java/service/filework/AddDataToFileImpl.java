package service.filework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class AddDataToFileImpl implements AddDataToFile {
    private static final String COMMA = ",";

    @Override
    public void addInStorage(Map<String, Integer> fruitAndQuantity,String filePath) {
        StringBuilder builderFQ = new StringBuilder();
        for (Map.Entry<String, Integer> fruits : fruitAndQuantity.entrySet()) {
            builderFQ.append(fruits.getKey())
                    .append(COMMA).append(fruits.getValue())
                    .append(System.lineSeparator());
            try {
                Files.write(Path.of(filePath),
                        builderFQ.toString().getBytes(),
                        StandardOpenOption.APPEND);
                builderFQ.delete(0,builderFQ.length());
            } catch (IOException e) {
                throw new RuntimeException("Sorry can't write data ",e);
            }
        }
    }
}
