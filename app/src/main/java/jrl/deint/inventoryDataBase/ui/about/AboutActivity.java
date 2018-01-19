package jrl.deint.inventoryDataBase.ui.about;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import jrl.deint.inventoryDataBase.R;
import mehdi.sakout.aboutpage.AboutPage;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.about_icon_email)
                .addGroup("Conecte con nosotros")
                .addEmail("jroldan686@gmail.com")
                .addWebsite("https://github.com/jroldan686/Inventory/")
                .addGitHub("jroldan686")
                .create();

        super.setContentView(aboutPage);
    }
}
