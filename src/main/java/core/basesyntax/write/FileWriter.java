package core.basesyntax.write;

import core.basesyntax.util.TotalFruitOnStorage;
import java.io.IOException;

public class FileWriter {
    public void writingToFile() {
        String headOfFile = "fruit, quantity\n";
        TotalFruitOnStorage totalFruitOnStorage = new TotalFruitOnStorage();
        try (java.io.FileWriter writer = new java.io.FileWriter("notes3.csv", false)) {
            String text = headOfFile + totalFruitOnStorage.totalFruit();
            writer.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
