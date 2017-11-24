package jrl.deint.inventoryFragments.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

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
    public void onSuccess() {
        loginView.navigateToHome();
    }

    /**
     * Destruye los objetos inicializados en el constructor
     * apuntando a null porque la vista se va a destruir
     */
    @Override
    public void onDestroy() {
        loginView = null;
        loginInteractor = null;
    }
}
