package core.basesyntax.service.impl;

public class FileReaderResult {
    private String content;

    public FileReaderResult(String content) {
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getLines() {
        return content.split("\n");
    }
}
