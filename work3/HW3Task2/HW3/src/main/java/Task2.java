import java.util.Arrays;
import java.util.Random;

public class Task2 {
    // Истомин Сергей Андреевич, группа 4832
    /**
     *Доработать приложение, которое мы разрабатывали на уроке. Мы доллжны поработать с сортировкой объектов,
     * освоить работу с интерфейсами Comparator, Comparable.
     *
     * 1. Доработать класс Freelancer, при желании можно разработать и свой собтственный тип сотрудника.
     * Формула расчета среднемесячной заработной платы может быть такова: «среднемесячная заработная
     * плата = 20.8 * 8 * почасовая ставка»
     * 2. Переработать метод generateEmployees, метод должен создавать случайного сотрудника (
     * Worker, Freelancer или любого другого). Метод должен быть один!
     * 3. Придумать свой собственный компаратор (Возможно отсортировать сотрудников по возрасту?
     * Тогда добавьте соответствующее состояние на уровне ваших классов).
     * 4. Продемонстрировать сортировку объектов различного типа с использованием собственного компаратора.
     */
    static Random random = new Random();

    static Worker generateWorker(){
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

        int age = random.nextInt(18, 70);
        int salary = random.nextInt(50000, 110000);
        Worker worker = new Worker(surnames[random.nextInt(surnames.length)], names[random.nextInt(names.length)], salary, age);
        return worker;
    }

    static Freelancer generateFreelancer(){
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

        int age = random.nextInt(18, 70);
        int hourlySalary = random.nextInt(100, 300);
        Freelancer freelancer = new Freelancer(surnames[random.nextInt(surnames.length)], names[random.nextInt(names.length)],
                hourlySalary, age);
        return freelancer;
    }

    /**
     * TODO: Переработать метод generateEmployees. Метод должен возвращать массив сотрудников
     *  разных типов (Worker, Freelancer), метод должен быть ОДИН!
     * @param count
     * @return
     */

    static Employee[] generateEmployees(int count){
        Employee[] employees = new Employee[count];
        for (int i = 0; i < employees.length; i++)
            if ((i % 2) != 0) {
                employees[i] = generateWorker();
            } else {
                employees[i] = generateFreelancer();
            }


        return employees;
    }

    public static void main(String[] args) {

        Employee[] employees = generateEmployees(15);
        System.out.println("Вывод без сортировки:");
        for (Employee employee: employees) {
            System.out.println(employee);
        }

        System.out.println(" ");
        System.out.println("Сортировка по возрастанию з/п:");
        Arrays.sort(employees, new SalaryComparator(SortType.Ascending));

        for (Employee employee: employees) {
            System.out.println(employee);
        }

        System.out.println();
        System.out.println("Сортировка по убыванию з/п:");
        Arrays.sort(employees, new SalaryComparator(SortType.Descending));

        for (Employee employee: employees) {
            System.out.println(employee);
        }

        System.out.println();
        System.out.println("Сортировка по возрастанию возраста:");
        Arrays.sort(employees, new AgeComparator(SortType.Ascending));

        for (Employee employee: employees) {
            System.out.println(employee);
        }

        System.out.println();
        System.out.println("Сортировка по убыванию возраста:");
        Arrays.sort(employees, new AgeComparator(SortType.Descending));

        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }

}

