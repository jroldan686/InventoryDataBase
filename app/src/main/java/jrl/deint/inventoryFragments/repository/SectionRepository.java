package jrl.deint.inventoryFragments.repository;

import java.util.ArrayList;

import jrl.deint.inventoryFragments.data.db.model.Section;

/**
 * Created by usuario on 26/10/17.
 */

public class SectionRepository {

    /* Declaración */
    private ArrayList<Section> sections;
    private static SectionRepository sectionRepository;

    /* INICIALIZACIÓN */
    /* Inicializar todos los atributos de ámbito estático o de clase */
    static {
        sectionRepository = new SectionRepository();
    }

    /**
     * El método ha de ser privado para garantizar que sólo hay una instanciq de Repository
     */
    private SectionRepository() {
        this.sections = new ArrayList();
        initialize();
    }

    /* MÉTODOS */
    public void initialize() {
        addSection(new Section(1, "Armario izquierdo puerta izquierda", "AIPI", "Interior puerta izquierda del armario de la izquierda", 1, true, true));
        addSection(new Section(2, "Armario izquierda puerta derecha", "AIPD", "Interior puerta derecha del armario de la izquierda", 1, true, false));
        addSection(new Section(3, "Armario derecho puerta izquierda", "ADPI", "Interior puerta izquierda del armario de la derecha", 1, true, false));
        addSection(new Section(4, "Armario derecho puerta derecha", "ADPD", "Interior puerta derecha del armario de la derecha", 1, true, false));
    }

    /* Patrón Singletón */
    public static SectionRepository getInstance() {
        if(sectionRepository == null)
            sectionRepository = new SectionRepository();
        return sectionRepository;
    }

    /**
     * Método que añade una sección
     * @param section
     */
    public void addSection(Section section) {
        sections.add(section);
    }

    public ArrayList<Section> getSections() {
        return sections;
    }
}
