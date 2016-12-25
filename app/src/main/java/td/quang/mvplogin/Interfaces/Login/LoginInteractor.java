package td.quang.mvplogin.Interfaces.Login;

/**
 * Created by Quang_TD on 12/25/2016.
 */

public interface LoginInteractor {
    void login(String username, String password, OnLoginFinishedListener listener);
}
