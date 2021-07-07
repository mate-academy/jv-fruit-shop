package writer;

public interface Writer<K, J> {
    void write(K writeTo, J data);
}
