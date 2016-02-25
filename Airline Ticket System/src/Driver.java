import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by dongsoo on 1/7/2016.
 */
public class Driver {
    static Scanner input = new Scanner(System.in);
    static Passenger[][] plane = new Passenger[10][4];
    static int confirmMe = (int) (1000 + Math.random() * 10000);

    public static void main(String args[]) {
        int choice = menu();
        while (choice != 6) {
            if (choice == 1) {
                printPlane();
            } else if (choice == 2) {
                buyFirstClassTicket();

            } else if (choice == 3) {
                buyEconomyClassTicket();
            } else if (choice == 4) {
           printTicket();
            }
            else if(choice==5){
                printArraylist(getUnderAgePassenger());
            }


            choice = menu();//last line of while loop(sentinel loop)
        }


    }

    private static void printArraylist(ArrayList<Passenger> getUnderagepassenger) {
        for(int i = 0;i<getUnderagepassenger.size();i++){
            System.out.println(getUnderagepassenger.get(i).getLast()+","+getUnderagepassenger.get(i).getFirst()+"  "+getUnderagepassenger.get(i).getAge()+"  "+getUnderagepassenger.get(i).getConfirmationNumber());
        }
    }

    public static ArrayList<Passenger> getUnderAgePassenger(){
        ArrayList<Passenger> Underage=new ArrayList<>();
        for (int i = 0; i < plane.length; i++) {
            for (int j = 0; j < plane[i].length; j++) {
                if(plane[i][j]!=null&&plane[i][j].getAge()<18){
                    Underage.add(plane[i][j]);
                    return Underage;
                }
            }

    }return Underage;}

    private static void printTicket() {
        System.out.println("Enter your confirmation code: ");
        int confirmCode = input.nextInt();
        Location a = getLocationOfConfirmationCode(confirmCode);
        int i = a.getRow();
        int j = a.getCol();

       { System.out.println("------------------------------------------------------");
        System.out.println("|");
        System.out.println("|              Confirmation Code: " + plane[i][j].getConfirmationNumber()+"\t\t\t\t|");
        System.out.println("|");
        System.out.println("|              Name:" + plane[i][j].getFirst() + "," + plane[i][j].getLast()+"\t\t\t\t|");
        System.out.println("|              Age:"+plane[i][j].getAge()+"\t\t\t\t|");
           System.out.println("|              Seat:"+i+","+j);

           if(plane[i][j].isMale()==true){
        System.out.println("|              Sex: Male\t\t\t\t|");}
           else System.out.println("|              Sex: Female\t\t\t\t|");
        System.out.println("------------------------------------------------------");
    }}

    private static Location getLocationOfConfirmationCode(int confirmMe) {
        Location a = new Location(0, 0);
        for (int i = 0; i < plane.length; i++) {
            for (int j = 0; j < plane[i].length; j++) {
                if (plane[i][j]!=null&&plane[i][j].getConfirmationNumber() == confirmMe) {
                    a = new Location(i, j);
                    return a;
                }
            }

        }
        return a;
    }


    private static void buyEconomyClassTicket() {
        for (int i = plane.length / 3; i < plane.length - plane.length / 3; i++) {
            for (int j = 0; j < plane[i].length; j++) {
                if (plane[i][j] == null) {
                    createFirstClassTicket(i, j);
                    return;
                }
            }

        }
    }

    private static void buyFirstClassTicket() {
        for (int i = 0; i < plane.length / 3; i++) {
            for (int j = 0; j < plane[i].length; j++) {
                if (plane[i][j] == null) {
                    createFirstClassTicket(i, j);

                    return;
                }
            }

        }
    }

    private static void createFirstClassTicket(int i, int j) {
        System.out.print("Enter passenger first name:");
        String first = input.next();
        System.out.print("Enter passenger last name:");
        String last = input.next();
        System.out.print("Enter your sex: m or f");
        String sex = input.next();
        System.out.print("Enter passenger age:");
        int age = input.nextInt();
        System.out.print("Enter book date:mm/dd/yy");
        String date = input.next();

        int confirmationNumber = confirmMe;
        confirmMe++;
        boolean male;
        if (sex.equals("m"))
            male = true;
        else male = false;
        plane[i][j] = new Passenger(first, last, male, age, date, confirmationNumber);
        System.out.println("Ticket Purchased, Confirmation code:" + confirmationNumber);
        //String bookDate = new String(3,3,3);


    }

    private static void printPlane() {

        for (int i = 0; i < plane.length; i++) {
            for (int j = 0; j < plane[i].length; j++) {
                if (j == 0) {
                    System.out.print("\t\t");
                } else if (j == 2) {
                    System.out.print("\t");
                }
                if (plane[i][j] != null) {
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }

    private static int menu() {
        System.out.println();
        System.out.println("1. Print Plane Seating Availability");
        System.out.println("2. Purchase First Class Ticket");
        System.out.println("3. Purchase Economy Class Ticket");
        System.out.println("4. Print Ticket");
        System.out.println("5. check under age passenger;");
        System.out.println("6. Quit");
        System.out.println();
        System.out.println("Enter choice");
        return input.nextInt();
    }
}
