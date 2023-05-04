// Реализуйте структуру телефонной книги с помощью HashMap учитывая, что 1 человек может иметь несколько телефонов.
// Нужны методы добавления новой записи в книгу и метод поиска записей в телефонной книге

package dz_five;

import java.util.*;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> phonebook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите нужное действие :");
            System.out.println("1.Добавить новую запись в книгу");
            System.out.println("2.Поиск записей в книге ");
            int answer = scanner.nextInt();
            switch (answer) {
                case 1:
                    Write(phonebook);
                    break;
                case 2:
                    Read(phonebook);
                    break;
                default:
                    System.out.println("Введите корректные данные ");
                    return;
            }
        }
    }

    public static void Write(Map<String, ArrayList<String>> phonebook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию:");
        String lastName = scanner.nextLine();
        System.out.println("Введите номер телефона:");
        String phoneNumber = scanner.nextLine();
        if (phonebook.containsKey(lastName)) {
            ArrayList<String> temp = phonebook.get(lastName);
            temp.add(phoneNumber);
            phonebook.put(lastName, temp);
        } else {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(phoneNumber);
            phonebook.put(lastName, temp);
        }
    }

    public static void Read(Map<String, ArrayList<String>> phonebook) {
        for (var items : phonebook.entrySet()) {
            System.out.println(items.getKey() + " " + items.getValue());
        }
    }
}
