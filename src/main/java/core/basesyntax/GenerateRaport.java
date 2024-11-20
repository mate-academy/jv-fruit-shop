package core.basesyntax;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class GenerateRaport {
    private static final String RESULT_FILE_NAME = "EndDayRaport.csv";

    public void generateRaport(Map<String, Integer> fruitQuantity) {
        File raport = new File(RESULT_FILE_NAME);

        try {
            if (!raport.exists()) {
                raport.createNewFile();
            }
            try (FileWriter fileWriter = new FileWriter(raport)) {
                fileWriter.write("fruit,quantity\n");

                for (Map.Entry<String, Integer> entry : fruitQuantity.entrySet()) {
                    String fruit = entry.getKey();
                    Integer quantity = entry.getValue();
                    fileWriter.write(fruit + "," + quantity + "\n");
                }
            } catch (IOException e) {
                throw new RuntimeException("Can't write in that file!", e);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't create that file!", e);
        }
    }
}
