package core.storageParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {
    private String path;
    private String fileName;
    private String extension;
    private String topLine;

    public FileServiceImpl() {
        this.path = "";
        this.extension = ".csv";
        this.fileName = "FileOut";
        this.topLine = "fruit,quantity";
    }

    public FileServiceImpl(String path, String extension, String fileName) {
        this.path = path;
        this.extension = extension;
        this.fileName = fileName;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> readFile() {
        List<String> lines = new ArrayList<>();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path+fileName+extension))) {
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.remove(0);
        return lines;
    }

    @Override
    public boolean writeFile(List<String> text) {
        try (FileWriter fw = new FileWriter(path+fileName+extension)) {
            fw.write(topLine);
            for(String line:text){
                fw.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
