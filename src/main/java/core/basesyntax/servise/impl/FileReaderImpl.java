package core.basesyntax.servise.impl;

import core.basesyntax.model.OperationsList;
import core.basesyntax.servise.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReaderImpl implements FileReader {
    @Override
    public void read(File file) {
       //File file = new File("input.csv");
       try {
           BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
           String operation = bufferedReader.readLine();
           while(operation != null) {
               OperationsList.list.add(operation);
               operation = bufferedReader.readLine();
           }
           OperationsList.list.remove(0);
       } catch (IOException e) {
           throw new RuntimeException("Can't read from file", e);
       }
    }
}
