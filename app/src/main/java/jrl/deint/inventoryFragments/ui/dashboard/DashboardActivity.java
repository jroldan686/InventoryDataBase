package jrl.deint.inventoryFragments.ui.dashboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import jrl.deint.inventoryFragments.ui.inventory.InventoryApplication;
import jrl.deint.inventoryFragments.ui.inventory.InventoryFragmentsActivity;
import jrl.deint.inventoryFragments.ui.preferences.PreferencesActivity;
import jrl.deint.inventoryFragments.ui.product.ProductActivity;
import jrl.deint.inventoryFragments.R;
import jrl.deint.inventoryFragments.ui.section.SectionActivity;
import jrl.deint.inventoryFragments.ui.dependency.DependenciesActivity;
import jrl.deint.inventoryFragments.ui.settings.AccountSettingActivity;
import jrl.deint.inventoryFragments.ui.settings.GeneralSettingActivity;

public class DashboardActivity extends AppCompatActivity {

    private GridLayout gridDashboard;
    private ClickListenerDashboard listenerDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        gridDashboard=(GridLayout)findViewById(R.id.gridDashboard);

        // Definir un array de int, que contendrá el id de las imágenes
        /*int[] images = {R.drawable.chair, R.drawable.closet, R.drawable.cpu, R.drawable.keyboard, R.drawable.monitor,
                        R.drawable.mouse, R.drawable.printer, R.drawable.proyector, R.drawable.table, R.drawable.whiteboard,
                        R.drawable.inventory};
        */

        int[] images = {R.drawable.inventory2, R.drawable.products, R.drawable.dependencies, R.drawable.sections, R.drawable.preferences};

        // No se utiliza en Java/Android array de objetos. Se utiliza Vector o Colecciones que son más eficientes.
        //ImageView[] imageViews = new ImageView[images.length];

        // No utilizamos la clase Vector porque no trabajamos con hilos y no se requiere sincronización
        //Vector<ImageView> vectorImageViews = new Vector<ImageView>();
        /*
        // ArrayList debe ser parametrizado
        ArrayList arrayImageViews = new ArrayList();
        for(int i=0; i<images.length; i++) {
            arrayImageViews.add(new ImageView(this));
            if(arrayImageViews.get(i) instanceof ImageView) {
                ((ImageView)arrayImageViews.get(i)).setImageResource(images[i]);
            }
        }
        */
        listenerDashboard = new ClickListenerDashboard();
        ImageView imageView;
        float width = getResources().getDimension(R.dimen.imgDashboardWidth);
        float heigth = getResources().getDimension(R.dimen.imgDashboardHeight);

        for(int i=0; i<images.length; i++) {
            imageView = new ImageView(this);
            imageView.setId(images[i]);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = (int)width;
            params.height = (int)heigth;
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            imageView.setImageResource(images[i]);
            imageView.setLayoutParams(params);
            imageView.setOnClickListener(new ClickListenerDashboard());
            gridDashboard.addView(imageView);
        }

    }

    class ClickListenerDashboard implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.drawable.inventory2:
                    intent = new Intent(DashboardActivity.this, InventoryFragmentsActivity.class);
                    break;
                case R.drawable.products:
                    intent = new Intent(DashboardActivity.this, ProductActivity.class);
                    break;
                case R.drawable.dependencies:
                    intent = new Intent(DashboardActivity.this, DependenciesActivity.class);
                    break;
                case R.drawable.sections:
                    intent = new Intent(DashboardActivity.this, SectionActivity.class);
                    break;
                case R.drawable.preferences:
                    intent = new Intent(DashboardActivity.this, PreferencesActivity.class);
            }
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_dashboard, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_account_setting:
                startActivity(new Intent(this, AccountSettingActivity.class));
                break;
            case R.id.action_general_setting:
                startActivity(new Intent(this, GeneralSettingActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAppPreferences() {
        SharedPreferences sharedPreferences = ((InventoryApplication).getApplicationContext()).getAppPreferencesHelper();
        appPreferencesHelper.getCurrentUserName("Lolita"));
        String message = "Tu usuario de sesión es " + sharedPreferences.getCurrentUserName();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
