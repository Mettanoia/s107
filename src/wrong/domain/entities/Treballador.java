package wrong.domain.entities;

import java.util.OptionalDouble;

@FunctionalInterface
public interface Treballador {
    @Deprecated
    OptionalDouble calcularSou(double workedHours);
}
