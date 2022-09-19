package service.writereadcsv;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import model.FruitTransaction;

public class FruitServiceWriterCsvImpl implements FruitServiceWriterCsv {

    @Override
    public void writeToFileCsv(List<FruitTransaction> list, String fileToPath) {
        File file = new File(fileToPath);
        try {
            Files.write(file.toPath(),"fruit,quantity".getBytes());
            for (FruitTransaction fruitTransaction : list) {
                Files.write(file.toPath(),System.lineSeparator().getBytes(),
                        StandardOpenOption.APPEND);
                Files.write(file.toPath(), fruitTransaction.getName().getBytes(),
                        StandardOpenOption.APPEND);
                Files.write(file.toPath(),",".getBytes(),
                        StandardOpenOption.APPEND);
                Files.write(file.toPath(),String.valueOf(fruitTransaction.getQuantity()).getBytes(),
                        StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file " + file.getPath(), e);
        }
    }
}
