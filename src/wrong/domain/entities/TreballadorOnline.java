package wrong.domain.entities;

import java.util.OptionalDouble;

public class TreballadorOnline extends AbstractTreballador {

    private static final double ONLINE_SALARY_PLUS = 12.0;

    public TreballadorOnline(String name, String surname, double eurPerHour) {
        super(name, surname, eurPerHour);
    }

    @Override
    @Deprecated
    public OptionalDouble calcularSou(double workedHours) {
        return OptionalDouble.of(this.eurPerHour * workedHours + ONLINE_SALARY_PLUS);
    }



}
