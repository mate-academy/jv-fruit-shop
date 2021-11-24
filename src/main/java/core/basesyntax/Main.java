package core.basesyntax;

import core.basesyntax.bd.Storage;
import service.*;
import service.implement.*;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src\\main\\resources\\input.csv";
    private static final String PATH_TO_OUTPUT_FILE = "src\\main\\resources\\output.csv";

    public static void main(String[] args) {
        FileReader reader = new FileReaderImplement();
        LineParser parser = new LineParserImp();
        ParceOutputValueService parse = new ParceOutputValue();
        FruitCounter counter = new FruitCounterImpl();
        FileWriter writer = new FileWriterImpl();

        counter.fruitCounter(parser.lineParcer(reader.read(PATH_TO_INPUT_FILE)));
        writer.write(parse.storageToString(Storage.storage), PATH_TO_OUTPUT_FILE);
    }
}
