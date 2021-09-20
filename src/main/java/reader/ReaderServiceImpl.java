package reader;

import model.Fruit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public List<Fruit> read(String path) {
       try(BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {

       } catch (IOException e) {
           throw new RuntimeException("Cant read data from file " + path);
       }
    }
}
