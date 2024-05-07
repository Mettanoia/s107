package wrong.domain.entities;

import java.util.OptionalDouble;
import java.util.function.Function;

public final class TreballadorImpl extends AbstractTreballador {

    private final Function<Double, OptionalDouble> souCalculatorMixin;

    public TreballadorImpl(String name, String surname, double eurPerHour, Function<Double, OptionalDouble> souCalculatorMixin) {
        super(name, surname, eurPerHour);
        this.souCalculatorMixin = souCalculatorMixin;
    }

    @Override
    public OptionalDouble calcularSou(double workedHours) {
        return this.souCalculatorMixin.apply(workedHours);
    }

}
