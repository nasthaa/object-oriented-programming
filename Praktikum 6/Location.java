public class Location{
    public static void main(String[] args) {
        Location loc1 = new Location(112.75, -7.25); 
        Location loc2 = new Location(106.82, -6.17);

        System.out.println("Jarak: " + loc1.distanceTo(loc2) + " km");
    }

    public double longitude;
    public double latitude;

    public Location(double longitude, double latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public double distanceTo(Location destination){
        double RADIUS = 6371.01;
        double latA = this.latitude;
        double lonA = this.longitude;
        double latB = destination.latitude;
        double lonB = destination.longitude;

        double temp = Math.cos(Math.toRadians(latA))
            * Math.cos(Math.toRadians(latB))
            * Math.cos(Math.toRadians((latB) - (latA)))
            + Math.sin(Math.toRadians(latA))
            * Math.sin(Math.toRadians(latB));
        return temp * RADIUS * Math.PI / 180;
    }
}
