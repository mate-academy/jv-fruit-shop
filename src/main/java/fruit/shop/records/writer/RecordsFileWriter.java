package fruit.shop.records.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RecordsFileWriter implements RecordsWriter {
    @Override
    public void writeRecords(String fileName, List<String> records) {
       try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
           for(String r : records) {
               bufferedWriter.write(r);
           }
       } catch (IOException e) {
           System.out.println("Something went wrong! Data wasn't written.");
       }
    }
}
