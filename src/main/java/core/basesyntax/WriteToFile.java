package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class WriteToFile {
    public void csvFileWriter(String fileToSavePath, String updateFromFile) throws IOException {
        UpdateStorageImpl updater = new UpdateStorageImpl();
        updater.parseFileToStorage(updateFromFile);
        PrintWriter writer = new PrintWriter(new File(fileToSavePath));
        StringBuilder formattedData = new StringBuilder("fruit,quantity\n");
        for (String fruit : Storage.fruitsInStore.keySet()) {
            int fruitInstanceSum = 0;
            for (LocalDate expirationDate : Storage.fruitsInStore.get(fruit).keySet()) {
                fruitInstanceSum += Storage.fruitsInStore.get(fruit).get(expirationDate);
            }
            formattedData.append(fruit).append(',').append(fruitInstanceSum).append('\n');
        }
        writer.write(formattedData.deleteCharAt(formattedData.length() - 1).toString());
        writer.close();
    }
}
