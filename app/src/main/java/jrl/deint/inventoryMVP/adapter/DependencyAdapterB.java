package jrl.deint.inventoryMVP.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.github.ivbaranov.mli.MaterialLetterIcon;

import jrl.deint.inventoryMVP.R;
import jrl.deint.inventoryMVP.pojo.Dependency;
import jrl.deint.inventoryMVP.repository.DependencyRepository;

/**
 * Created by usuario on 26/10/17.
 * ES LA PRIMERA SOLUCIÓN NO OPTIMIZADA
 */

public class DependencyAdapterB extends ArrayAdapter<Dependency> {
    public DependencyAdapterB(@NonNull Context context, int resource, @NonNull Dependency[] objects) {
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MaterialLetterIcon mliIcon;
        TextView txvName;
        TextView txvShortName;

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

        }

        // 3. Inicializar las variables a los objetos ya creados de los widget del xml. ¡¡CUIDADO View.findViewId!!

        mliIcon = (MaterialLetterIcon) view.findViewById(R.id.mliIcon);
        txvName = (TextView) view.findViewById(R.id.txvName);
        txvShortName = (TextView) view.findViewById(R.id.txvShortName);

        // 4. Mostrar los datos del ArrayList mediante position.
        mliIcon.setLetter(getItem(position).getShortname().substring(0, 1));
        txvName.setText(getItem(position).getName());
        txvShortName.setText(getItem(position).getShortname());

        // Busca con findById tantos elementos como haya en la vista

        return view;
    }
}
