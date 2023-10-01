/**
 * Рабочий (фулл-тайм)
 */
public class Worker extends Employee{

    public Worker(String surName, String name, double salary, int age) {
        super(surName, name, salary, age);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Среднемесячная заработная плата (фиксированная): %.2f (руб.), возраст %d",
                surName, name, calculateSalary(), age);
    }
}
