package jrl.deint.inventoryDataBase.ui.inventory;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import jrl.deint.inventoryDataBase.R;
import jrl.deint.inventoryDataBase.ui.dashboard.DashboardActivity;

public class InventoryFragmentsActivity extends AppCompatActivity {

    private TextView txvSignUp;
    private Button btnSignIn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txvSignUp = (TextView)findViewById(R.id.txvSignUp);
        txvSignUp.setPaintFlags(txvSignUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(InventoryFragmentsActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
