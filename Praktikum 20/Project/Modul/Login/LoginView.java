package Modul.Login;

import Base.BasePresenter;
import Base.BaseView;

public class LoginView implements BaseView {
    public BasePresenter mPresenter;

    public void generatePresenter(BasePresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    public void start() {
        System.out.println("Login View dimulai...");
    }
}
