public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        DepartemenData departemenData = new DepartemenData();
        ConsoleValidator validator = new ConsoleValidator();
        MahasiswaCRUD mahasiswaCRUD = new MahasiswaCRUD(dataManager, departemenData, validator);
        AppMenu appMenu = new AppMenu(mahasiswaCRUD, validator);

        appMenu.start();
    }
}
