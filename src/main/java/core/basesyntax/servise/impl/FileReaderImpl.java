package core.basesyntax.servise.impl;

import core.basesyntax.model.OperationsList;
import core.basesyntax.servise.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReaderImpl implements FileReader {
    private static final int HEAD_OF_INPUT = 0;

    @Override
    public void read(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            String operation = bufferedReader.readLine();
            while (operation != null) {
                OperationsList.list.add(operation);
                operation = bufferedReader.readLine();
            }
            OperationsList.list.remove(HEAD_OF_INPUT);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
