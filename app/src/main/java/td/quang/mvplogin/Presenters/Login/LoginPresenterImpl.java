package td.quang.mvplogin.Presenters.Login;

import td.quang.mvplogin.Interfaces.Login.LoginInteractor;
import td.quang.mvplogin.Interfaces.Login.LoginPresenter;
import td.quang.mvplogin.Interfaces.Login.LoginView;
import td.quang.mvplogin.Interfaces.Login.OnLoginFinishedListener;
import td.quang.mvplogin.Models.Login.LoginInteractorImpl;

/**
 * Created by Quang_TD on 12/25/2016.
 */

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validate(String username, String password) {
        loginView.showProgress();
        loginInteractor.login(username, password, this);
    }

    @Override
    public void onUsernameError() {
        loginView.setUsernameError();
        loginView.hideProgress();
    }

    @Override
    public void onPasswordError() {
        loginView.setPasswordError();
        loginView.hideProgress();
    }

    @Override
    public void onSuccess() {
        loginView.navigateToHome();
    }
}
