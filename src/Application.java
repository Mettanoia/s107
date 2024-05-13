import wrong.domain.entities.*;

import java.util.List;
import java.util.OptionalDouble;

/**
 * <p>Crea una jerarquia d’objectes amb tres classes:  Treballador, TreballadorOnline i TreballadorPresencial.</p>
 *
 * <p>La classe Treballador té els atributs nom, cognom, preu/hora, i el mètode calcularSou() que rep per paràmetre el nombre d'hores treballades i el multiplica pel preu/hora. Les classes filles l'han de sobreescriure,  emprant @Override. </p>
 *
 * <p>Des del main() de la classe Principal, fes les invocacions necessàries per demostrar el funcionament de l’anotació @Override.</p>
 *
 * <p>En els treballadors presencials, el mètode per calcular el seu sou, rebrà per paràmetre el nombre d’hores treballades al mes. A l’hora de calcular el sou es multiplicarà el nombre d’hores treballades pel preu/hora, més el valor d'un atribut static anomenat benzina que afegirem en aquesta classe.</p>
 *
 * <p>En els treballadors online, el mètode per calcular el seu sou rebrà per paràmetre el nombre d'hores treballades al mes. A l'hora de calcular el sou es multiplicarà el nombre d'hores treballades pel preu/hora i se li sumarà el preu de la tarifa plana d'Internet, que serà una constant de la classe TreballadorOnline.</p>
 */

public class Application implements Runnable {

    @Override

    @SuppressWarnings("deprecation")
    public void run() {

        List<Treballador> treballadorList = getTreballadors();

        for (Treballador t : treballadorList) {
            System.out.println(t + "--" + t.calcularSou(5.0).toString());

        }

    }

    private static List<Treballador> getTreballadors() {

        // The use of this pattern may seem superfluous here, but in case I needed to provide other parts of the code with
        // treballador implementations this would apply the Dependency Inversion Principle so other components
        // depend exclusively in the factory and don't have a source code dependency on any of the treballador implementations.

        Treballador treballadorOnline = new TreballadorAbstractFactory(
                () -> new TreballadorOnline("Nom", "Cognom", 23.9)
        ).getTreballador();

        Treballador treballadorPresencial = new TreballadorAbstractFactory(
                () -> new TreballadorPresencial("Nom", "Cognom", 23.9)
        ).getTreballador();

        // Since the only difference between the different implementations lies just in the constants, and the implementation
        // of a single method, we could achieve greater polymorphism and reusability without polluting the class
        // hierarchy unnecessarily by using composition and lambdas instead of full-fledged inheritance

        Treballador composedTreballadorOnline = new TreballadorImpl("Nom", "Cognom", 23.9,
                d -> OptionalDouble.of(23.9 * d + 12.0)
        );

        Treballador composedTreballadorPresencial = new TreballadorImpl("Nom", "Cognom", 23.9,
                d -> OptionalDouble.of(23.9 * d + 10.0)
        );

        // There is a trade-off between two options. Both enforce the Dependency Inversion Principle, but the first one
        // is better at encapsulating and enforcing a particular constant since there is an abstraction for it.
        // The second one is more reusable, since creating arbitrarily large class hierarchies is not the best way to
        // reuse code, composition is, and in this case lambda expressions simply allow us to have a clearer syntax

        return List.of(treballadorOnline, treballadorPresencial, composedTreballadorOnline, composedTreballadorPresencial);
    }
}
