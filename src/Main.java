import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        printIsLeapYear(2021);
        printSetSystem(0, 2023);
        System.out.print(calculateDeliveryDays(95));

    }
    /*
        Реализуйте метод, который получает в качестве параметра год, проверяет, является ли он високосным, и выводит результат в консоль.
        Эту проверку вы уже реализовывали в задании по условным операторам.
        "Напишите программу, которая определяет, является ли год високосным или нет.
        Переменную года назовите year, в которую можно подставить значение интересующего нас года.
        Например, 2021."
        Теперь проверку оберните в метод и используйте год, который приходит в виде параметра.
        Результат программы выведите в консоль.*/

    public static void printIsLeapYearOutput(int year, boolean yearIsLeap) {
        if(yearIsLeap) {
            System.out.println(year + " год - високосный год");
        } else {
            System.out.println(year + " год - не високосный год");
        }
    }
    public static void printIsLeapYear (int year) {
        printIsLeapYearOutput(year, isLeap(year));
    }
    public static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 == 0 && year % 400 == 0;
    }
    /*
        Вспомните задание 2 из урока «Условные операторы», где вы предлагали пользователю облегченную версию приложения.
        "У банка появилось мобильное приложение.
        Когда пользователь заходит на сайт с телефона, ему предлагается скачать приложение с учетом операционной системы и года выпуска телефона.
        Ваша задача — написать программу, которая выдает соответствующее сообщение клиенту при наличии двух условий.
        Если год выпуска ранее 2015 года, то к сообщению об установке нужно добавить информацию об облегченной версии:
        Для iOS: «Установите облегченную версию приложения для iOS по ссылке».
        Для Android: «Установите облегченную версию приложения для Android по ссылке».
        Для пользователей телефонов 2015 года выпуска и позже нужно вывести обычное предложение об установке приложения.
        Для года создания телефона используйте переменную clientDeviceYear, в которой необходимо указать 2015 год."
        Напишите метод, куда подаются два параметра: тип операционной системы (0 — iOS, 1 — Android ) и год выпуска устройства.
        Если устройство старше текущего года, предложите ему установить облегченную версию.
        Текущий год можно получить таким способом: int currentYear = LocalDate.now().getYear();
        Или самим задать значение вручную — ввести в переменную числовое значение.
        В результате программа должна выводить в консоль сообщение, какую версию приложения и для какой ОС установить пользователю.*/
        public static void versionOperatingSystem (int clientOS, int deviceYear) {
            boolean deviceIsOld = isDevaiceOld(deviceYear);
            System.out.print("Установите ");
            if (deviceIsOld){
                System.out.print(" облегченную ");
            }
            System.out.print(" версию приложения ");
            if (clientOS==0) {
                System.out.println(" iOS");
            }else {
                System.out.println(" Android");
            }
        }
        public static void printSetSystem (int clientDevice, int clientDevaiceYear){
            String version = " ";
            if (clientDevaiceYear < 2015) {
                version = " облегченную ";
            }
            String device = " ";
            if (clientDevice == 0) {
                device = " iOS";
            } else if (clientDevice == 1) {
                device = " Android";
            }
            System.out.println("Установите " + version + " версию приложения для " + device + " по ссылке");
        }
        public static boolean isDevaiceOld(int devaiceYear) {
            int currentYear = LocalDate.now().getYear();
            return devaiceYear <= currentYear;
    }
        public static String getVersionByYear (int year) {
            return year < LocalDate.now().getYear() ? "облегченную" : "";
        }

    /* Возвращаемся к задаче на расчет дней доставки банковской карты.
    "В банке для клиентов организовывается доставка карт на дом. Чтобы известить клиента о том, когда будет доставлена его карта, нужно знать расстояние от офиса до адреса доставки.
    Правила доставки такие:
    Доставка в пределах 20 км занимает сутки.
    Доставка в пределах от 20 км до 60 км добавляет еще один день доставки.
    Доставка в пределах от 60 км до 100 км добавляет еще одни сутки.
    Свыше 100 км доставки нет.
    То есть с каждым следующим интервалом доставки срок увеличивается на 1 день.
    Напишите программу, которая выдает сообщение в консоль: "Потребуется дней: " + срок доставки.
    Объявите целочисленную переменную deliveryDistance = 95, которая содержит дистанцию до клиента."
    Ваша задача — доработать код, а именно написать метод, который на вход принимает дистанцию и возвращает итоговое количество дней доставки.*/
    public static String calculateDeliveryDays (int deliveryDistance) {
        int deliveryDays = 1;
        if (deliveryDistance >= 20 && deliveryDistance < 60) {
            deliveryDays++;
        }
        if (deliveryDistance >= 60 && deliveryDistance <= 100) {
            deliveryDays++;
        } else if (deliveryDistance > 100) {
            System.out.println("Ошибка");

        } return "Потребуется дней: " + deliveryDays;

    }
}