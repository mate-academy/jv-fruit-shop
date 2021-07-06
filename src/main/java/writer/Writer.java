package writer;

public interface Writer<K, J> {
    String write(K writeTo, J data);
}
