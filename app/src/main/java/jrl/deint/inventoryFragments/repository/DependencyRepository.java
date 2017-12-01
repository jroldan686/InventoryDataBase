package jrl.deint.inventoryFragments.repository;

import java.util.ArrayList;
import java.util.Collections;

import jrl.deint.inventoryFragments.data.db.model.Dependency;

/**
 * Created by usuario on 26/10/17.
 */

public class DependencyRepository {

    /* Declaración */
    private ArrayList<Dependency> dependencies;
    private static DependencyRepository dependencyRepository;

    /* INICIALIZACIÓN */
    /* Inicializar todos los atributos de ámbito estático o de clase */
    static {
        dependencyRepository = new DependencyRepository();
    }

    /**
     * El método ha de ser privado para garantizar que sólo hay una instanciq de Repository
     */
    private DependencyRepository() {
        this.dependencies = new ArrayList<>();
        initialize();
    }

    /* MÉTODOS */
    public void initialize() {
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "1CFGS", "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "2CFGS", "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(3, "1º Ciclo Formativo Grado Medio",
                "1CFGM", "1CFGM Sistemas Microinformáticos y Redes"));
        addDependency(new Dependency(4, "2º Ciclo Formativo Grado Medio",
                "2CFGM", "2CFGM Sistemas Microinformáticos y Redes"));
    }

    /* Patrón Singletón */
    public static DependencyRepository getInstance() {
        if(dependencyRepository == null)
            dependencyRepository = new DependencyRepository();
        return dependencyRepository;
    }

    /**
     * Método que añade una dependencia
     * @param dependency
     */
    public void addDependency(Dependency dependency) {
        dependency.set_ID(dependencies.size());
        dependencies.add(dependency);
    }

    public ArrayList<Dependency> getDependencies() {
        /**
         * El ArrayList se ordena según el/los criterio/s del método compareTo
         * de la interfaz Comparable
         */
        Collections.sort(dependencies);
        // Si se desea que sort() use Comparator, se pasa como segundo parámetro
        Collections.sort(dependencies, new Dependency.DependencyOrderByShortName());
        return dependencies;
    }

    public boolean validateDependency(String name, String sortname) {
        return true;
    }

    public void editDependency(Dependency dependency, String description) {
        int index = dependencies.indexOf(dependency);
        dependency.setDescription(description);
        dependencies.set(index, dependency);
    }

    public boolean exists(String name, String shortname) {
        boolean found = false;
        for (int i = 0; i < dependencies.size() && !found; i++) {
            if(dependencies.get(i).getName().equals(name) &&
                    dependencies.get(i).getShortname().equals(shortname)) {
                found = true;
            }
        }
        return found;
    }

    public boolean deleteDependency(Dependency dependency) {
        return dependencies.remove(dependency);
    }
}
