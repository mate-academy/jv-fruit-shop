package core.basesyntax;

import core.basesyntax.service.FruitCounter;
import core.basesyntax.service.MyFileReader;
import core.basesyntax.service.MyFileWriter;
import core.basesyntax.service.impl.FruitCounterImpl;
import core.basesyntax.service.impl.MyFileReaderImpl;
import core.basesyntax.service.impl.MyFileWriterImpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyFileReader myFileReader = new MyFileReaderImpl();
        FruitCounter fruitCounter = new FruitCounterImpl();
        MyFileWriter myFileWriter = new MyFileWriterImpl();

        File input = new File("src\\main\\resources\\input.csv");
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(input))) {
            fileWriter.write("type,fruit,quantity\n"
                        + "b,banana,20\n"
                        + "b,apple,100\n"
                        + "s,banana,100\n"
                        + "p,banana,13\n"
                        + "r,apple,10\n"
                        + "p,apple,20\n"
                        + "p,banana,5\n"
                        + "s,banana,50");
        } catch (IOException e) {
            throw new RuntimeException("Could not assess the file", e);
        }

        List<String> info = myFileReader.getDryInfo(input);
        List<String> handledInfo = fruitCounter.countFruits(info);
        File report = myFileWriter.writeReport(handledInfo);
    }
}
