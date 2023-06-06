package fruit.shop.records.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecordsFileReader implements RecordsReader {

    @Override
    public List<String> getRecords(String fileName) {
        List<String> records = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.readLine() != null) {
                records.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            System.out.println("Something went wrong! Data wasn't read.");
        }
        return records;
    }


}
