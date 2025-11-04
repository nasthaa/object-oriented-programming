public class Main {
    public static void main(String[] args) {
        System.out.println("--- SCENARIO 1: USING MYSQL ---");
        DBConnectionInterface mySQL = new MySQLConnection();
        PasswordReminder reminderMySQL = new PasswordReminder(mySQL);
        reminderMySQL.sendReminders();

        System.out.println("--- SCENARIO 2: SWITCHING TO POSTGRESQL ---");
        DBConnectionInterface postgreSQL = new PostgreSQLConnection();
        PasswordReminder reminderPostgreSQL = new PasswordReminder(postgreSQL);
        reminderPostgreSQL.sendReminders();

        System.out.println("--- SCENARIO 3: USING SIMULATED CONNECTION ---");
        DBConnectionInterface simulatedConn = new SimulatedConnection();
        PasswordReminder reminderSimulated = new PasswordReminder(simulatedConn);
        reminderSimulated.sendReminders();
    }
}