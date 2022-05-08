import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            while (true){
                Scanner scanner = new Scanner(System.in);
                System.out.println();
                System.out.println();
                System.out.println("Изберете номер на задача:");
                System.out.println("1.Напишете Java програма, за да обърнете низ, без да използвате вградена функция reverse ().");
                System.out.println("2.Напишете Java програма, за да преброите броя на думите в низ, използвайки HashMap.");
                System.out.println("3.Напишете Java програма, за да обходите ArrayList, използвайки for, while.");
                System.out.println("4.Напишете Java програма, за да намерите дублиращите се символи в низ.");
                System.out.println("5.Напишете Java програма, за да прочетете Excel.");
                System.out.println("6.Край");
                System.out.print("Въведете номер задача:");
                int n = scanner.nextInt();
                if(n == 1){
                    Tasks.task1();
                }else if(n == 2){
                    Tasks.task2();
                }else if(n == 3){
                    Tasks.task3();
                }else if(n == 4){
                    Tasks.task4_solution_2();
                }else if(n == 5){
                    Tasks.task5();
                }else if(n == 6){
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
