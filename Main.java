import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int answer;

        do {
            System.out.println("What would you like to store?" +
                    "\n1) Integers" +
                    "\n2) Strings" +
                    "\n3) Doubles" +
                    "\n4) Exit");
            answer = obj.nextInt();

            switch (answer) {
                case 1:
                    ArrayList<Integer> intList = new ArrayList<>();
                    getIntNum(intList);
                    handleIntegerList(intList, obj);
                    break;
                case 2:
                    ArrayList<String> stringList = new ArrayList<>();
                    getStringInput(stringList);
                    handleStringList(stringList, obj);
                    break;
                case 3:
                    ArrayList<Double> doubleList = new ArrayList<>();
                    getDoubleInput(doubleList);
                    handleDoubleList(doubleList, obj);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (answer != 4);
    }

    private static void getIntNum(ArrayList<Integer> list) {
        Scanner obj = new Scanner(System.in);
        System.out.println("How many integers would you like to store?");
        int count = obj.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Integer " + (i + 1) + ":");
            int num = obj.nextInt();
            list.add(num);
        }
    }

    private static void handleIntegerList(ArrayList<Integer> list, Scanner obj) {
        int choice;
        do {
            System.out.println("What would you like to do with the integer list?" +
                    "\n1) Add two numbers" +
                    "\n2) View my list" +
                    "\n3) Sort my list" +
                    "\n4) Exit");
            choice = obj.nextInt();
            switch (choice) {
                case 1:
                    addIntNum(list, obj);
                    break;
                case 2:
                    displayList(list);
                    break;
                case 3:
                    sortIntList(list);
                    displayList(list);
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 4);
    }

    private static void addIntNum(ArrayList<Integer> list, Scanner obj) {
        System.out.println("Enter indices of two numbers to add together:");
        displayList(list);
        System.out.println("First: ");
        int index1 = obj.nextInt();
        System.out.println("Now second: ");
        int index2 = obj.nextInt();
        int size = list.size();
        if (index1 >= 0 && index1 < size && index2 >= 0 && index2 < size) {
            int result = list.get(index1) + list.get(index2);
            System.out.println("The sum of " + list.get(index1) + " and " + list.get(index2) + " is " + result);
        } else {
            System.out.println("Invalid indices.");
        }
    }

    private static void getStringInput(ArrayList<String> list) {
        Scanner obj = new Scanner(System.in);
        System.out.println("How many strings would you like to store?");
        int count = obj.nextInt();
        obj.nextLine(); // Consume newline character
        for (int i = 0; i < count; i++) {
            System.out.println("String " + (i + 1) + ":");
            String str = obj.nextLine();
            list.add(str);
        }
    }

    private static void handleStringList(ArrayList<String> list, Scanner obj) {
        int choice;
        do {
            System.out.println("What would you like to do with the string list?" +
                    "\n1) View my list" +
                    "\n2) Count values in a specific index range" +
                    "\n3) Exit");
            choice = obj.nextInt();
            switch (choice) {
                case 1:
                    displayList(list);
                    break;
                case 2:
                    countValuesInIndexRange(list, obj);
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 3);
    }

    private static void countValuesInIndexRange(ArrayList<String> list, Scanner obj) {
        System.out.println("Enter the start index:");
        int start = obj.nextInt();
        System.out.println("Enter the end index:");
        int end = obj.nextInt();
        if (start >= 0 && start < list.size() && end >= start && end < list.size()) {
            int count = end - start + 1;
            System.out.println("Number of values in the range [" + start + ", " + end + "]: " + count);
        } else {
            System.out.println("Invalid indices.");
        }
    }

    private static void getDoubleInput(ArrayList<Double> list) {
        Scanner obj = new Scanner(System.in);
        System.out.println("How many doubles would you like to store?");
        int count = obj.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Double " + (i + 1) + ":");
            double num = obj.nextDouble();
            list.add(num);
        }
    }

    private static void handleDoubleList(ArrayList<Double> list, Scanner obj) {
        int choice;
        do {
            System.out.println("What would you like to do with the double list?" +
                    "\n1) View my list" +
                    "\n2) Sort my list" +
                    "\n3) Exit");
            choice = obj.nextInt();
            switch (choice) {
                case 1:
                    displayList(list);
                    break;
                case 2:
                    sortDoubleList(list);
                    displayList(list);
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 3);
    }

    private static void sortIntList(ArrayList<Integer> list) {
        Collections.sort(list);
    }
    private static void sortDoubleList(ArrayList<Double> list) {
        Collections.sort(list);
    }
    private static <T> void displayList(ArrayList<T> list) {
        System.out.println("Items in the list:");
        for (T item : list) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
}
