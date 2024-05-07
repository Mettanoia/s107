package wrong.domain.entities;

import java.util.OptionalDouble;

/**
 * Template for {@link Treballador Treballador} implementations that follow a particular pattern.
 */
public abstract class AbstractTreballador implements Treballador{

    protected final String name;
    protected final String surname;
    protected final double eurPerHour;

    AbstractTreballador(String name, String surname, double eurPerHour) {
        this.name = name;
        this.surname = surname;
        this.eurPerHour = eurPerHour;
    }

    String getName() {
        return name;
    }

    double getEurPerHour() {
        return eurPerHour;
    }

    String getSurname() {
        return surname;
    }

    /**
     * Calculates the salary based on the number of hours and a particular value dependant upon the particular type. If
     * for some reason the computation is not possible, then the result is empty.
     *
     * @param workedHours hours the {@link Treballador Treballador} has worked
     * @return the total salary of the {@link Treballador Treballador}
     */
    @Override
    public abstract OptionalDouble calcularSou(double workedHours);

    @Override
    public String toString() {
        return "AbstractTreballador{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", eurPerHour=" + eurPerHour +
                '}';
    }
}
