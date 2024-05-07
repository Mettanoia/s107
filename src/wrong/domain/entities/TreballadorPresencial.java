package wrong.domain.entities;

import java.util.OptionalDouble;

public class TreballadorPresencial extends AbstractTreballador {

    private static final double IN_PERSON_SALARY_PLUS = 10.0;

    public TreballadorPresencial(String name, String surname, double eurPerHour) {
        super(name, surname, eurPerHour);
    }

    @Override
    public OptionalDouble calcularSou(double workedHours) {
        return OptionalDouble.of(this.eurPerHour * workedHours + IN_PERSON_SALARY_PLUS);
    }

}
