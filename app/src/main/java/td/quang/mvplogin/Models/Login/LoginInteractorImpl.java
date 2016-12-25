package td.quang.mvplogin.Models.Login;


import android.os.Handler;

import td.quang.mvplogin.Interfaces.Login.LoginInteractor;
import td.quang.mvplogin.Interfaces.Login.OnLoginFinishedListener;

/**
 * Created by Quang_TD on 12/25/2016.
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(String username, String password, OnLoginFinishedListener listener) {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            boolean error = false;
            if (!username.equals("username")) {
                listener.onUsernameError();
                error = true;
            }
            if (!password.equals("password")) {
                listener.onPasswordError();
                error = true;
            }
            if (!error) {
                listener.onSuccess();
            }
        }, 2000);
    }
}
