package jrl.deint.inventoryFragments.ui.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import jrl.deint.inventoryFragments.ui.inventory.InventoryMVPActivity;
import jrl.deint.inventoryFragments.R;

public class SplashActivity extends AppCompatActivity {

    ImageView imgvImagen;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgvImagen = (ImageView)findViewById(R.id.imageView);
        imgvImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setClass(SplashActivity.this, InventoryMVPActivity.class);
                startActivity(intent);
            }
        });
    }
}
