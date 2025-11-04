import java.util.List;

public interface DBConnectionInterface {
    void connect(String connectionInfo);
    void disconnect();
    List<String> executeQuery(String query);
    boolean isConnected();
}