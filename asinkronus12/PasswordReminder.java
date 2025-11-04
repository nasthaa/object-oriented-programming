import java.util.List;

// After Refactoring:
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