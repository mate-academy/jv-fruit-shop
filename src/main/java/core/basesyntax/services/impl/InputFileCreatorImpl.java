package core.basesyntax.services.impl;

import core.basesyntax.services.InputFileCreator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InputFileCreatorImpl implements InputFileCreator {
    private static final String INPUT_DATA = "type,fruit,quantity\n"
                    + "b,banana,20\n"
                    + "b,apple,100\n"
                    + "s,banana,100\n"
                    + "p,banana,13\n"
                    + "r,apple,10 \n"
                    + "p,apple,20 \n"
                    + "p,banana,5 \n"
                    + "s,banana,50";

    public boolean create(String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(INPUT_DATA);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write data to file" + filePath, e);
        }
        return true;
    }
}
