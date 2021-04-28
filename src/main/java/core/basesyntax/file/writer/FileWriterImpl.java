package core.basesyntax.file.writer;

import core.basesyntax.model.Fruit;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(BufferedWriter bufferedWriter, List<Fruit> fruitList) throws IOException {
        for (Fruit fruit : fruitList) {
            bufferedWriter.write("\n" + fruit.getName() + "," + fruit.getBalance());
        }
    }
}
