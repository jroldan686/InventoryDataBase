package jrl.deint.inventoryDataBase.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import jrl.deint.inventoryDataBase.data.db.model.Dependency;

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
        /*
        int index = dependencies.indexOf(dependency);
        dependency.setDescription(description);
        dependencies.set(index, dependency);
        */
        for (Dependency tempDependency : dependencies)
            if(tempDependency.getName().equals(dependency.getName()))
                dependency.setDescription(description);
    }
/*
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
*/
    public boolean exists(Dependency dependency) {
        return dependencies.contains(dependency);
    }

    /**
     * Método que salva una dependencia en el repositorio/BD
     * @param d es el objeto Dependency
     */
    public void saveDependency(Dependency d) {
        // Esta es la sintaxis de un foreach en Android
        for(Dependency dependency:dependencies) {
            if(dependency.get_ID() == d.get_ID())
                dependency.setDescription(d.getDescription());
        }
    }

    public void deleteDependency(Dependency d) {
        //return dependencies.remove(dependency);

        // No se puede eliminar el objeto directamente por lo que para eliminar
        // de la colección NO SE PUEDE USAR FOREACH PORQUE LA RECORRE EN MODO LECTURA

        // Foreach usa Iterator por lo que se crea uno propio
        // De esta forma se recupera el puntero Iterator de la colección
        Iterator<Dependency> iterator = dependencies.iterator();
        Dependency dependency;
        while (iterator.hasNext()) {
            dependency = iterator.next();
            if(dependency.get_ID() == d.get_ID()) {
                iterator.remove();
                break;
            }
        }
    }
}
