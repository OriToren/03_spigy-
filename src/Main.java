import java.util.Arrays;
import java.util.Scanner;
/* Ori Toren
   Daniel Yakovson
 */
public class Main {
    public static boolean inArray(String[] array, String given_name,int size ){
        for (int i = 0; i < size; i++){
            if (array[i].equals(given_name)){
                return true;
            }

        } return false;
    }




    public static String[] arrayAddition(String[] array,int size,String variable){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add "+variable+" name: ");
        String given_name = scanner.nextLine();
        if (inArray(array, given_name,size)) {
            System.out.println("Seems that "+variable+" is already listed. Press 1 to add a different "+variable+" or 2 to go back to the menu.");
            int wheretogo = scanner.nextInt();
            if (wheretogo == 1) {
                return arrayAddition(array, size,variable);
            } else {
                return array;
            }
        } else {
            array[size] = given_name;
            return array;
        }
    }





    public static String[] duplicateArray(String[] originalArray){
        int newSize = originalArray.length * 2;
        String[] newArray = new String[newSize];
        for (int i=0; i <originalArray.length; i++){
            newArray[i]=originalArray[i];
        }
        for (int i = originalArray.length; i < newSize; i++) {
            newArray[i] = "";
        }
        return newArray;

    }







    public static int optionPanelprint(){
        System.out.println("Please type the desired option from the options menu: ");
        System.out.println("options menu: ");
        System.out.println("0)Exit menu-");
        System.out.println("1)Add teacher-");
        System.out.println("2)Add group-");
        System.out.println("3)Add teachingsection-");
        System.out.println("4)Placment of a teacher to a group-");
        System.out.println("5)Average teacher payout-");
        System.out.println("6)Average pay in a spesific group-");
        System.out.println("7)Teacher details-");
        System.out.println("8)Group details-");
        Scanner scn = new Scanner(System.in);
        int choice = scn.nextInt();
        return choice;


    }






    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the college: ");
        String collegename = scanner.nextLine();
        String[] teacher_array = new String[5];
        int teacher_size = 0;
        String[] group_array = new String[5];
        int group_size = 0;
        String[] teachingsec_array = new String[5];
        int teachingsecsize = 0;
        int choice=-1;
        while (choice != 0){
            choice = optionPanelprint();
            if (choice == 1) {
                if (teacher_size == teacher_array.length) {
                    teacher_array = duplicateArray(teacher_array);
                }
                teacher_array = arrayAddition(teacher_array, teacher_size,"teacher");
                teacher_size++;
            }
            if (choice == 2) {
                if (group_size == group_array.length) {
                    group_array = duplicateArray(group_array);
                }
                group_array= arrayAddition(group_array,group_size,"group");
                group_size++;
            }

            if (choice == 3) {
                if (teachingsecsize == teachingsec_array.length) {
                    teachingsec_array = duplicateArray(teachingsec_array);
                }
                teachingsec_array=arrayAddition(teachingsec_array,teachingsecsize,"teachingsection");
                teachingsecsize++;
            }
            if (choice==4){
                System.out.println("Enter the name of a teacher: ");
                String teacher = scanner.nextLine();
                System.out.println("Enter the name of a group: ");
                String group = scanner.nextLine();
                if (inArray(teacher_array,teacher,teacher_size) == false) {
                    System.out.println("that teacher doesnt exist");
                }
                if (inArray(group_array,group,group_size) == false){
                    System.out.println("that group doesnt exist");
                }
            }
            if (choice==7){
                System.out.println(Arrays.toString(teacher_array));
            }
            if (choice==8){
                System.out.println(Arrays.toString(group_array));
            }

        }

    }

}