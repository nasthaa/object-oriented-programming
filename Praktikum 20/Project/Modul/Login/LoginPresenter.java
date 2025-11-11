package Modul.Login;

import Base.BasePresenter;
import Data.Source.SessionRepository;

public class LoginPresenter implements BasePresenter {
    public SessionRepository sessionRepository;
    public LoginView view;

    public LoginPresenter(LoginView view, SessionRepository sessionRepository) {
        this.view = view;
        this.sessionRepository = sessionRepository;
        System.out.println("Login Presenter diinisialisasi...");
    }
}
