import java.util.Arrays;
import java.util.List;

class PostgreSQLConnection implements DBConnectionInterface {
    private boolean isConnected = false;
    
    @Override
    public void connect(String connectionInfo) {
        System.out.println("PostgreSQL: Connecting with '" + connectionInfo + "'");
        this.isConnected = true;
        System.out.println("PostgreSQL: Connection ready.");
    }

    @Override
    public void disconnect() {
        System.out.println("PostgreSQL: Disconnected.");
        this.isConnected = false;
    }

    @Override
    public List<String> executeQuery(String query) {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected to PostgreSQL!");
        }
        System.out.println("PostgreSQL: Running query '" + query + "'");
        return Arrays.asList("pg_user_A@example.com", "pg_user_B@example.com");
    }

    @Override
    public boolean isConnected() {
        return this.isConnected;
    }
}