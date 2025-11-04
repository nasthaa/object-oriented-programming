import java.util.Arrays;
import java.util.List;

// Before Refactoring:
// class MySQLConnection {
//     private boolean isConnected = false;

//     public void connect(String connectionString) {
//         System.out.println("MySQL: Connecting using '" + connectionString + "'");
//         this.isConnected = true;
//         System.out.println("MySQL: Connection established.");
//     }

//     public void disconnect() {
//         System.out.println("MySQL: Connection closed.");
//         this.isConnected = false;
//     }

//     public List<String> executeQuery(String query) {
//         if (!isConnected) {
//             throw new IllegalStateException("Not connected to MySQL database!");
//         }
//         System.out.println("MySQL: Executing query '" + query + "'");
//         return Arrays.asList("user1@example.com", "user2@example.com");
//     }

//     public boolean isConnected() {
//         return this.isConnected;
//     }
// }

// After Refactoring:
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

// Before Refactoring:
// class PasswordReminder {
//     private MySQLConnection dbConnection;

//     public PasswordReminder() {
//         this.dbConnection = new MySQLConnection();
//     }

//     public void sendReminders() {
//         dbConnection.connect("jdbc:mysql://localhost/prod_db");
        
//         if (dbConnection.isConnected()) {
//             List<String> usersToRemind = dbConnection.executeQuery("SELECT email FROM users WHERE reminder_due = true");
//             System.out.println("Found " + usersToRemind.size() + " users to remind.");

//             for(String userEmail : usersToRemind) {
//                 System.out.println("Sending reminder to: " + userEmail);
//             }
//         }
        
//         dbConnection.disconnect();
//     }
// }