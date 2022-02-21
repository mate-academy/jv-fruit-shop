package dao.impl;

import dao.FileHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandlerImpl implements FileHandler {
    @Override
    public String readData(String absoluteFilePath) {
        StringBuilder sourceDataInString = new StringBuilder();
        File fileToRead = new File(absoluteFilePath);
        int data;
        try {
            if (!fileToRead.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(fileToRead);
            data = fileReader.read();
            while (data != -1) {
                sourceDataInString.append((char) data);
                data = fileReader.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such file " + e);
        } catch (IOException e) {
            throw new RuntimeException("IOException " + e);
        }
        return sourceDataInString.toString();
    }

    @Override
    public void writeData(String dataToWrite, String absoluteFilePath) {
        File fileToWrite = new File(absoluteFilePath);
        try {
            if (!fileToWrite.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter writer = new FileWriter(fileToWrite);
            writer.append(dataToWrite);
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such file " + e);
        } catch (Exception e) {
            throw new RuntimeException("IOException " + e);
        }
    }
}
