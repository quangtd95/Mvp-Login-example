package td.quang.mvplogin.Views.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import td.quang.mvplogin.Interfaces.Login.LoginPresenter;
import td.quang.mvplogin.Interfaces.Login.LoginView;
import td.quang.mvplogin.Presenters.Login.LoginPresenterImpl;
import td.quang.mvplogin.R;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    private TextInputLayout txtLayoutName;
    private TextInputLayout txtLayoutPass;
    private EditText etName;
    private EditText etPass;
    private ProgressBar progressBar;
    private Button btnLogin;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new LoginPresenterImpl(this);
        addComponent();
        addEvent();
    }

    private void addEvent() {
        btnLogin.setOnClickListener(this);
    }

    private void addComponent() {
        txtLayoutName = (TextInputLayout) findViewById(R.id.txtLayoutName);
        txtLayoutPass = (TextInputLayout) findViewById(R.id.txtLayoutPass);
        etName = (EditText) findViewById(R.id.etName);
        etPass = (EditText) findViewById(R.id.etPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        txtLayoutName.setError("tên đăng nhập không được để trống");
    }

    @Override
    public void setPasswordError() {
        txtLayoutPass.setError("mật khẩu không được để trống");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        txtLayoutName.setErrorEnabled(false);
        txtLayoutPass.setErrorEnabled(false);
        presenter.validate(etName.getText().toString(), etPass.getText().toString());

    }
}
