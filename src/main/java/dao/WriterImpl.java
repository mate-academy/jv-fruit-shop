package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterImpl implements Writer{

    @Override
        public void reportWriter(Map<String, Integer> reportMap, String filePath) {
            String header = "fruit,quantity";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                    writer.write(header);
                    writer.newLine();
                    for (Map.Entry<String, Integer> entry : reportMap.entrySet()) {
                        writer.write(entry.getKey());
                        writer.write("," + entry.getValue());
                        writer.newLine();
                    }
                } catch (IOException e) {
                    throw new RuntimeException("Can't write this report");
                }
            }
        }

