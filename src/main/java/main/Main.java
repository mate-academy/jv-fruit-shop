package main;

import service.impl.Reader;
import service.impl.Writer;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.read("data.csv");
        Writer writer = new Writer();
        writer.write("newData.csv");
    }
}
