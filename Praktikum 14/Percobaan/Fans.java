class Fans {
    private String name;

    public Fans() {
        this.name = "noname";
    }
    
    public Fans(String name) {
        this.name = name;
    }

    public void showName() {
        System.out.print(name + "\t: ");
    }

    public void watchingPerformance() {
        showName();
        System.out.println("melihat idolanya dari YouTube");
    }

    public void watchingPerformance(Musician musician) {
        showName();
        System.out.print("melihat idolanya ");
        musician.perform();
        System.out.println();
    }
}