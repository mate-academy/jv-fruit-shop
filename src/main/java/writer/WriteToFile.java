package writer;

import dao.Columns;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile implements Writer<Integer, File, String> {
    @Override
    public String write(Integer index, File writeTo, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writeTo))) {
            bufferedWriter.write(Columns.getAllColumns(index) + data);
            return "File has successfully written!";
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: ", e);
        }
    }
}
