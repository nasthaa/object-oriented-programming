public class Alarm{

    public String id;
    public String description;
    public String date;
    public String time;

    public Alarm(String id, String description, String date, String time){
        this.id = id;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public void run(){
        System.out.println("Pukul " + time + ", " + date + ". Alarm " + description + " sedang berdering!");
    }

    public void terminate() {
        System.out.println("Pukul " + time + ", " + date + ". Alarm " + description + " dimatikan!");
    }

    public void snooze() {
        System.out.println("Pukul " + time + ", " + date + ". Alarm " + description + " ditunda selama 5 minutes.");
    }
    
    public static void main(String[] args) {
        Alarm alarm = new Alarm("1", "Bangun", "2025-09-08", "06:00");
        
        alarm.run();
        alarm.snooze();
        alarm.terminate();
    }
}