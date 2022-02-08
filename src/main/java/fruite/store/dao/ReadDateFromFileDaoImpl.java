package fruite.store.dao;

import java.io.*;

public class ReadDateFromFileDaoImpl implements ReadDateDao {
    @Override
    public String readDate(String fromFileName) {
        File file = new File(fromFileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't open the file: " + fromFileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the date from file: " + fromFileName, e);
        }
        return builder.toString();
    }
}
