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
        this.dependencies = new ArrayList();
        initialize();
    }

    /* MÉTODOS */
    public void initialize() {
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "1CFGS", "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "2CFGS", "2CFGS Desarrollo Aplicaciones Multiplataforma"));
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
}
