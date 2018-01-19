package jrl.deint.inventoryDataBase.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

import jrl.deint.inventoryDataBase.R;
import jrl.deint.inventoryDataBase.data.db.model.Dependency;

/**
 * Created by usuario on 26/10/17.
 */

public class DependencyAdapter extends ArrayAdapter<Dependency> {

    /**
     * Se crea una copia del ArrayList que se tiene en DependencyRepository
     * para tener una copia local en el Adapter que se pueda modificar sin
     * cambiar los datos originales
     * @param context
     */
    public DependencyAdapter(@NonNull Context context) {
        //super(context, R.layout.item_dependency, new ArrayList<>(DependencyRepository.getInstance().getDependencies()));
        //sort(new Dependency.DependencyOrderByShortName());
        super(context, R.layout.item_dependency, new ArrayList<Dependency>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        DependencyHolder dependencyHolder;
        View view = convertView;

        // Sólo se va a crear el objeto view las 8 primeras veces que se va a empezar a mostrar en pantalla hasta rellenarla
        if(convertView == null) {

            // 1. Obtener el servicio de sistema Layout Inflater en el contexto

            // Accede de forma genérica al servicio del sistema para inflar la vista del objeto view
            //LayoutInflater inflater = LayoutInflater.from(getContext());

            // Forma no recomendada, porque se obliga al contexto a provenir de una actividad
            //LayoutInflater inflater = ((Activity)getContext()).getLayoutInflater();

            // De esta forma se accede directamente al servicio específico
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // 2. Inflar la vista. Crea en memoria el objeto View con todos los widget del xml: item_dependency.xml

            // Con null indica que no hay que introducirlo en item_dependency
            view = inflater.inflate(R.layout.item_dependency, null);
            dependencyHolder = new DependencyHolder();

            // 3. Inicializar las variables a los objetos ya creados de los widget del xml. ¡¡CUIDADO View.findViewId!!

            dependencyHolder.mliIcon = (MaterialLetterIcon) view.findViewById(R.id.mliIcon);
            dependencyHolder.txvName = (TextView) view.findViewById(R.id.txvName);
            dependencyHolder.txvShortName = (TextView) view.findViewById(R.id.txvShortName);
            Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "font/Beleren-Bold");
            dependencyHolder.txvName.setTypeface(typeface);
            dependencyHolder.txvShortName.setTypeface(typeface);
            view.setTag(dependencyHolder);
        } else
            dependencyHolder = (DependencyHolder)view.getTag();

        // 4. Mostrar los datos del ArrayList mediante position.
        dependencyHolder.mliIcon.setLetter(getItem(position).getShortname().substring(0, 1));
        dependencyHolder.txvName.setText(getItem(position).getName());
        dependencyHolder.txvShortName.setText(getItem(position).getShortname());

        // Busca con findById tantos elementos como haya en la vista

        return view;
    }
    class DependencyHolder {
        MaterialLetterIcon mliIcon;
        TextView txvName;
        TextView txvShortName;
    }


}
