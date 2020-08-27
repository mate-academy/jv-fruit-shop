package core.basesyntax.stock.write;

import core.basesyntax.stock.manipulation.TotalFruitOnStorage;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public void writingToFile() {
        String headOfFile = "fruit, quantity\n";
        TotalFruitOnStorage totalFruitOnStorage = new TotalFruitOnStorage();
        try (FileWriter writer = new FileWriter("notes2.csv", false)) {
            String text = headOfFile + totalFruitOnStorage.totalFruit();
            writer.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
