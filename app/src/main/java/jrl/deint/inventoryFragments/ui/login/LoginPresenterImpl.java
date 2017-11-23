package jrl.deint.inventoryFragments.ui.login;

import jrl.deint.inventoryFragments.base.BaseActivity;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginPresenterImpl extends BaseActivity implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractorImpl loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }


    @Override
    public void validateCredentials(String user, String password) {

        loginInteractor.validateCredentials(user, password, this);

        //loginView.navigateToHome();

    }


    @Override
    public void onUserEmptyError() {
        loginView.setUserEmptyError();
    }

    @Override
    public void onPasswordEmptyError() {
        loginView.setPasswordEmptyError();
    }

    @Override
    public void onPasswordError() {
        loginView.setPasswordError();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        loginView = null;
        loginInteractor = null;
    }
}
