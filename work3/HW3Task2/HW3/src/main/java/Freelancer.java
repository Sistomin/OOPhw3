/**
 * TODO: Разработать тип Freelancer самостоятельно в рамках выполнения
 *  домашней работы
 * Фрилансер (работник с почасовой оплатой)
 */
public class Freelancer extends Employee{
    //double hourlySalary;
    public Freelancer(String surName, String name, double salary, int age) {
        super(surName, name, salary, age);
    }
    @Override
    public double calculateSalary() {
        double sum = (20.8 * 8 * salary);
        return sum;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Фрилансер; Среднемесячная заработная плата: %.2f (руб.), возраст %d",
                surName, name, calculateSalary(), age);
    }
}
