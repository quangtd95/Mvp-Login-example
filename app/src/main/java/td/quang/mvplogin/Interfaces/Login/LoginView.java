package td.quang.mvplogin.Interfaces.Login;

/**
 * Created by Quang_TD on 12/25/2016.
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

}
