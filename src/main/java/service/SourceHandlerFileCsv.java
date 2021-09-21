package service;

import dao.OperationDaoUseFileImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.FruitRecordDto;

public class SourceHandlerFileCsv implements SourceHandler {

    @Override
    public boolean readInputData(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                FruitRecordDto fruitRecordDto = new ParserFromFileImpl().pars(line);
                new OperationDaoUseFileImpl().add(fruitRecordDto);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("cannot read the file, check the file path" + path);
        }
        return true;
    }

    @Override
    public boolean writOutputData(String data, String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("The writing path is not correct.");
        }
        return true;
    }
}
