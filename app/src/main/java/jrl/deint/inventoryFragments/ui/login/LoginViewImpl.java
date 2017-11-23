package jrl.deint.inventoryFragments.ui.login;

import android.content.Intent;

import jrl.deint.inventoryFragments.R;
import jrl.deint.inventoryFragments.base.BaseActivity;

/**
 * Created by usuario on 13/11/17.
 */

public class LoginViewImpl extends BaseActivity implements LoginView {



    @Override
    public void navigateToHome() {
        Intent intent = new Intent(LoginViewImpl.this, );
    }

    @Override
    public void setUserEmptyError() {
        onError(R.string.errorUserEmpty);
    }

    @Override
    public void setPasswordEmptyError() {
        onError(R.string.errorPasswordEmpty);
    }

    @Override
    public void serPasswordError() {
        onError(R.string.errorPasswordLength);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
        loginPresenter = null;
    }
}
