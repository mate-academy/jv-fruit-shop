package service;

public interface SourceHandler {
    boolean readInputData(String path);

    boolean writOutputData(String data, String path);
}
