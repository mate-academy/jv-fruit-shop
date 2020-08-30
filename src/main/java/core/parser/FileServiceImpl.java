package core.parser;

import core.exceptions.FileEmptyException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {
    private String path;
    private String fileName;
    private String extension;
    private String topLine;
    private String fullPath;

    public FileServiceImpl() {
        this.path = "src\\test\\resources\\";
        this.extension = ".csv";
        this.fileName = "FileOut";
        this.topLine = "fruit,quantity";
        this.fullPath = path + fileName + extension;
    }

    public FileServiceImpl(String path, String fileName) {
        this.path = path;
        this.extension = ".csv";
        this.fileName = fileName;
        this.fullPath = path + fileName + extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
        refreshPath();
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        refreshPath();
    }

    public String getPath() {
        return fullPath;
    }

    public void setPath(String path) {
        this.path = path;
        refreshPath();
    }

    public List<String> readFile() {
        List<String> lines = new ArrayList<>();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fullPath))) {
            while ((line = br.readLine()) != null) {
                lines.add(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lines.isEmpty()) {
            throw new FileEmptyException("File is empty");
        }
        lines.remove(0);
        return lines;
    }

    @Override
    public boolean writeFile(List<String> text, String fileName) {
        setFileName(fileName);
        Path path = Paths.get(fullPath);
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter fw = new FileWriter(fullPath)) {
            fw.write(topLine);
            for (String line : text) {
                fw.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void refreshPath() {
        fullPath = path + fileName + extension;
    }
}
