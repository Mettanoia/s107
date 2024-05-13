package wrong.domain.entities;

import java.util.OptionalDouble;

@FunctionalInterface
public interface Treballador {
    OptionalDouble calcularSou(double workedHours);
}
