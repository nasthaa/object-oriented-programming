import java.util.Arrays;
import java.util.List;

// Langkah 1: Buat "Kontrak" (Interface) yang Diperkaya
interface DBConnectionInterface {
    void connect(String connectionInfo);
    void disconnect();
    List<String> executeQuery(String query);
    boolean isConnected();
}

// Langkah 2: Patuhi "Kontrak"
class MySQLConnection implements DBConnectionInterface {
    private boolean isConnected = false;

    @Override
    public void connect(String connectionString) {
        System.out.println("MySQL: Connecting using '" + connectionString + "'");
        this.isConnected = true;
        System.out.println("MySQL: Connection established.");
    }

    @Override
    public void disconnect() {
        System.out.println("MySQL: Connection closed.");
        this.isConnected = false;
    }

    @Override
    public List<String> executeQuery(String query) {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected to MySQL database!");
        }
        System.out.println("MySQL: Executing query '" + query + "'");
        return Arrays.asList("user1@example.com", "user2@example.com");
    }

    @Override
    public boolean isConnected() {
        return this.isConnected;
    }
}

// Langkah 3: Balikkan Ketergantungan (Invert the Dependency)
class PasswordReminder {
    private final DBConnectionInterface dbConnection;

    public PasswordReminder(DBConnectionInterface dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void sendReminders() {
        dbConnection.connect("jdbc:mysql://localhost/prod_db");
        
        if (dbConnection.isConnected()) {
            List<String> usersToRemind = dbConnection.executeQuery("SELECT email FROM users WHERE reminder_due = true");
            System.out.println("Found " + usersToRemind.size() + " users to remind.");

            for(String userEmail : usersToRemind) {
                System.out.println("Sending reminder to: " + userEmail);
            }
        }
        
        dbConnection.disconnect();
    }
}

//  Langkah 4: Buat Implementasi Baru yang Fleksibel
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

// Ekplorasi Tambahan: Simulated Connection
class SimulatedConnection implements DBConnectionInterface {
    private boolean isConnected = false;

    @Override
    public void connect(String connectionInfo) {
        System.out.println("SimulatedConnection: Simulasi koneksi untuk development.");
        this.isConnected = true;
    }

    @Override
    public void disconnect() {
        System.out.println("SimulatedConnection: Koneksi simulasi ditutup.");
        this.isConnected = false;
    }

    @Override
    public List<String> executeQuery(String query) {
        if (!isConnected()) throw new IllegalStateException("Belum terkoneksi ke simulasi DB!");
        System.out.println("SimulatedConnection: Menjalankan query '" + query + "'");
        return Arrays.asList("simulated_user1@example.com");
    }

    @Override
    public boolean isConnected() {
        return this.isConnected;
    }
}

// Langkah 5: Uji Fleksibilitas Kode Anda
public class RefactoredCode {
    public static void main(String[] args) {
        System.out.println("--- SCENARIO 1: USING MYSQL ---");
        DBConnectionInterface mySQL = new MySQLConnection();
        PasswordReminder reminderMySQL = new PasswordReminder(mySQL);
        reminderMySQL.sendReminders();

        System.out.println("--- SCENARIO 2: SWITCHING TO POSTGRESQL ---");
        DBConnectionInterface postgreSQL = new PostgreSQLConnection();
        PasswordReminder reminderPostgreSQL = new PasswordReminder(postgreSQL);
        reminderPostgreSQL.sendReminders();

        // Scenario 3: Using Simulated Connection
        System.out.println("--- SCENARIO 3: USING SIMULATED CONNECTION ---");
        DBConnectionInterface simulatedConn = new SimulatedConnection();
        PasswordReminder reminderSimulated = new PasswordReminder(simulatedConn);
        reminderSimulated.sendReminders();
    }
}