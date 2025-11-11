import Data.Source.UserSessionRepository;
import Modul.Login.LoginPresenter;
import Modul.Login.LoginView;

public class MainTest {
    public static void main(String[] args) {
        UserSessionRepository sessionRepository = new UserSessionRepository();
        Router router = new Router();

        LoginView loginView = new LoginView();

        LoginPresenter loginPresenter = new LoginPresenter(loginView, sessionRepository);

        loginView.generatePresenter(loginPresenter);

        router.login(loginView);
        loginView.start();
    }
}