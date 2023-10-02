package core.basesyntax.service;

import core.basesyntax.errors.DataReaderError;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataReaderCsv implements DataReader {
    @Override
    public String[] read(String fileName) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            throw new DataReaderError("Can't open data file " + fileName, e);
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] result = bufferedReader.lines()
                .toList()
                .toArray(new String[0]);
        if (result.length == 0) {
            throw new DataReaderError("Empty file " + fileName);
        }
        return result;
    }
}
