package jrl.deint.inventoryDataBase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import jrl.deint.inventoryDataBase.R;
import jrl.deint.inventoryDataBase.data.db.model.Section;
import jrl.deint.inventoryDataBase.repository.SectionRepository;

/**
 * Created by usuario on 30/10/17.
 */

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionViewHolder> {

    private ArrayList<Section> sections;

    // Array que almacenará las secciones que se han modificado en la interfaz y no se han guardado aún en la base de datos.
    // En nuestro caso en el Repository
    private ArrayList<Section> sectionsModified;
    //private OnSwitchCheckedChangeListener onSwitchCheckedChangeListener;
    private OnToggleCheckedChangeListener onToggleCheckedChangeListener;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void  OnItemClick(Section section);
    }

    public SectionAdapter() {
        sections = SectionRepository.getInstance().getSections();
        sectionsModified = new ArrayList<>();
    }

    /**
     * Constructor que se llamará cuando SectionActivity venga de un cambio de Configuración
     * y se haya salvado el estado dinámico.
     * @param sectionsModified
     */
    public SectionAdapter(ArrayList<Section> sectionsModified, OnItemClickListener listener) {
        sections = SectionRepository.getInstance().getSections();
        this.sectionsModified = sectionsModified;
        this.listener = listener;
    }

    @Override
    public SectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Aquí se llama a parent.getContext porque parent ya tiene la vista padre
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Inflar la vista. Crea en memoria el objeto View con todos los widget del xml: item_section.xml
        View view = inflater.inflate(R.layout.item_section, null);

        // 3. Se crea el objeto ViewHolder a partir de la vista.
        SectionViewHolder sectionViewHolder = new SectionViewHolder(view);
        return sectionViewHolder;
    }

    @Override
    public void onBindViewHolder(SectionAdapter.SectionViewHolder holder, int position) {
        holder.tgbEnabled.setChecked(sections.get(position).isEnabled());
        holder.tgbEnabled.setOnCheckedChangeListener(onToggleCheckedChangeListener);
        holder.txvName.setText(sections.get(position).getName());
        if(sections.get(position).isDefault())
            holder.txvDefault.setText(R.string.txvDefault);
        holder.bind(sections.get(position), listener);
    }


    /**
     * Se crearán tantos elementos SectionViewHolder como elementos haya en el ArrayList definido dentro de la clase.
     * @return
     */
    @Override
    public int getItemCount() {
        return sections.size();
    }

    public static class SectionViewHolder extends RecyclerView.ViewHolder {
        private ToggleButton tgbEnabled;
        private TextView txvName, txvDefault;

        public SectionViewHolder(View itemView) {
            super(itemView);
            tgbEnabled = (ToggleButton) itemView.findViewById(R.id.tgbEnabled);
            txvName = (TextView) itemView.findViewById(R.id.txvName);
            txvDefault = (TextView) itemView.findViewById(R.id.txvDefault);
        }

        public void bind (final Section section, final OnItemClickListener onItemClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(section);
                }
            });
        }
    }

    /**
     * Devuelve el array de las secciones que el usuario ha modificado
     * cuando la activity estaba visible y que aún no se ha guardado en
     * la base de datos (persistente)
     * @return ArrayList de secciones modificadas
     */
    public ArrayList<Section> getSectionsModified() {
        return sectionsModified;
    }

    class OnToggleCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        }
    }
}

/*
    public SectionAdapter(@NonNull Context context, int resource, @NonNull Section[] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        SectionHolder sectionHolder;
        View view = convertView;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_section, null);
            sectionHolder = new SectionAdapter.SectionHolder();

            sectionHolder.tgbEnabled = (ToggleButton) view.findViewById(R.id.tgbEnabled);
            sectionHolder.txvName = (TextView) view.findViewById(R.id.txvName);
            sectionHolder.txvDefault = (TextView) view.findViewById(R.id.txvDefault);
            view.setTag(sectionHolder);
        } else
            sectionHolder = (SectionAdapter.SectionHolder)view.getTag();

        //sectionHolder.tgbEnabled.
        sectionHolder.txvName.setText(getItem(position).getName());
        sectionHolder.txvDefault.setText(getItem(position).isDefault());

        return view;
}
class SectionHolder {
    ToggleButton tgbEnabled;
    TextView txvName;
    TextView txvDefault;
}
*/