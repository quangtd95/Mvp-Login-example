package td.quang.mvplogin.Interfaces.Login;

/**
 * Created by Quang_TD on 12/25/2016.
 */

public interface OnLoginFinishedListener {
    void onUsernameError();

    void onPasswordError();

    void onSuccess();
}
