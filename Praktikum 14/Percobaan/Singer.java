class Singer extends Musician {
    @Override
    public void perform() {
        super.perform();
        System.out.print(", bernyanyi dengan merdu");
    }
}