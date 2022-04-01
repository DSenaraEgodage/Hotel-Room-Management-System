import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Hotel {
    public static void main(String[] args){
        Room rm1=new Room(); //initialization new objects, rm1
        Room rm2=new Room(); //initialization new objects, rm2
        Room rm3=new Room(); //initialization new objects, rm3
        Room rm4=new Room(); //initialization new objects, rm4
        Room rm5=new Room(); //initialization new objects, rm5
        Room rm6=new Room(); //initialization new objects, rm6
        Room rm7=new Room(); //initialization new objects, rm7
        Room rm8=new Room(); //initialization new objects, rm8

        Person p1 = new Person(); //initialization new objects, p1
        Person p2 = new Person(); //initialization new objects, p2
        Person p3 = new Person(); //initialization new objects, p3
        Person p4 = new Person(); //initialization new objects, p4
        Person p5 = new Person(); //initialization new objects, p5
        Person p6 = new Person(); //initialization new objects, p6
        Person p7 = new Person(); //initialization new objects, p7
        Person p8 = new Person(); //initialization new objects, p8

        Queue_Str queue_str = new Queue_Str();
        Queue_Num queue_num = new Queue_Num();
        Room[] rooms ={rm1, rm2, rm3, rm4, rm5, rm6, rm7, rm8}; //initializing Array object
        Person[] persons = {p1, p2, p3, p4, p5, p6, p7, p8}; //initializing Array object
        main_menu(rooms,persons,queue_str,queue_num);
    }

    public static void main_menu(Room[] rooms, Person[] persons, Queue_Str queue_str, Queue_Num queue_num){
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("   --Main_Menu--");
        System.out.println("");
        Scanner input = new Scanner(System.in);//make a scanner for inputs
        System.out.print(" A  (Add a new customer)\n " + //user selection
                "V (View List of Rooms)\n " +
                "E (Display Empty Rooms)\n " +
                "D (Delete Customer from Room)\n " +
                "F (Find Room from Customer name)\n "+
                "S (Find Room from Customer name)\n "+
                "L (Find Room from Customer name)\n "+
                "O (Find Room from Customer name)\n\n"+
                "Enter the option (A / V / E / D / F / S / L / O) : ");
        String opt = input.nextLine();
        opt=opt.toUpperCase();
        if(opt.equals("A")){ //if option is equal to A call newCustomer method
            newCustomer(rooms,persons,queue_str,queue_num);
        }else if(opt.equals("V")){//if option is equal to V call viewList method
            viewList(rooms,persons,queue_str,queue_num);
        }else if(opt.equals("E")){//if option is equal to E all emptyRoom method
            emptyRooms(rooms,persons,queue_str,queue_num);
        } else if(opt.equals("D")){ //if option is equal to D call deleteCustomer method
            deleteCustomer(rooms,persons,queue_str,queue_num);
        }else if(opt.equals("F")){ //if option is equal to F call findCustomer method
            findCustomer(rooms,persons,queue_str,queue_num);
        }else if(opt.equals("S")){ //if option is equal to S call storeData method
            storeData(rooms,persons,queue_str,queue_num);
        }else if(opt.equals("L")){//if option is equal to S call loadData method
            loadData(rooms,persons,queue_str,queue_num);
        }/*else if (opt.equals("O")) {//if option is equal to S call orderAlphabetical method
            orderAlphabetically(rooms,persons,queue_str,queue_num);
        }*/else{
            System.out.println("Enter correct option");
            main_menu(rooms,persons,queue_str,queue_num);
        }
    }


    public static void newCustomer(Room[] rooms,Person[] persons,Queue_Str queue_str, Queue_Num queue_num){
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("   --Add_a_new_customer--"); //message given to the user
        Scanner input = new Scanner(System.in);

        int i=0;
        for (int x=0; x<8; x++){
            if(rooms[x].name.equals("e")){
                i+=1;
            }
        }
        if (i!=0) {

            System.out.print("Enter the Room Number          : ");
            int roomN = input.nextInt();//take user input
            if(rooms[roomN-1].name.equals("e") ){
                input.nextLine();//reads next line
                System.out.print("Enter the Name of Customer      : ");
                String c_name = input.nextLine();
                rooms[roomN - 1].name = c_name;
                System.out.print("Enter the First Name of Customer: ");
                persons[roomN - 1].f_name = input.nextLine();
                System.out.print("Enter the Surname of Customer   : ");
                persons[roomN - 1].s_name = input.nextLine();
                System.out.print("Enter Number of Guests          : ");
                persons[roomN - 1].g_number = input.nextInt();
                System.out.print("Enter Credit Card Number        : ");
                persons[roomN - 1].c_number = input.nextInt();
            }else{
                System.out.println("Room got a customer yet.");
            }


        }else{
            System.out.println("     ===Queue===");
            System.out.print("Enter the Name of Customer  : ");
            String c_name = input.nextLine();
            System.out.print("Enter First Name of Customer: ");
            String f_name = input.nextLine();
            System.out.print("Enter Surname of Customer   : ");
            String s_name = input.nextLine();
            System.out.print("Enter Number of Guests      : ");
            int g_number = input.nextInt();
            System.out.print("Enter Credit Card Number    : ");
            int c_number = input.nextInt();
            queue_str.empty_queue(c_name,f_name,s_name);
            queue_num.empty_queue(g_number,c_number);
        }

        System.out.print("Enter Q for Exit: ");//quit main menu
        input.nextLine();
        String com = input.nextLine();
        if (com.equals("q")||com.equals("Q")){
            main_menu(rooms,persons,queue_str, queue_num); //calling main_menu
        }else{
            newCustomer(rooms,persons,queue_str,queue_num);
        }
    }

    public static void viewList(Room[] list,Person[] persons, Queue_Str queue_str, Queue_Num queue_num){
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("   --View_List_of_Rooms--"); //message given to the user
        Scanner input = new Scanner(System.in);
        for(int x=0;x<8;x++){//display full list
            System.out.println("Room num " + (x+1) + " is booking "+ list[x].name); //index is 1 less than room number
            System.out.println("First Name   : "+persons[x].f_name); //.f_name - object feature
            System.out.println("Surname      : "+persons[x].s_name); //.s_name - object feature
            System.out.println("Guest Number : "+persons[x].g_number); //.g_number - object feature
            System.out.println("First Name   : "+persons[x].c_number); //.c_number - object feature
            System.out.println();
        }
        main_menu(list,persons,queue_str, queue_num); //calling main_menu
    }

    public static void emptyRooms(Room[] empty, Person[] persons, Queue_Str queue_str, Queue_Num queue_num){
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("   --Display_Empty_Rooms--"); //message given to the user
        Scanner input = new Scanner(System.in);
        int n=0;
        for (int x=0;x<8;x++){
            if(empty[x].name.equals("e")){ //show empty room
                System.out.println("Room num "+ (x+1)+" is empty");
                n+=1;
            }
        }
        if(n==0){
            System.out.println("No empty rooms in the hotel");
        }

        main_menu(empty,persons,queue_str,queue_num); //calling main_menu

    }
    public static void deleteCustomer(Room[] del,Person[] persons,Queue_Str queue_str,Queue_Num queue_num){
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("   --Delete_Customer_from_Room--"); //message given to the user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the room number you want to delete from list: ");
        int num = input.nextInt(); //deleted room input
        del[num-1].name="e";
        persons[num-1].f_name="e"; // deleting all using "e" and 0
        persons[num-1].s_name="e";
        persons[num-1].c_number=0;
        persons[num-1].g_number=0;

        String[] names =new String[3];
        names= queue_str.del_queue();
        int [] nums=new int[2];
        nums=queue_num.del_queue();


        del[num-1].name=names[0];
        persons[num-1].f_name=names[1]; // deleting all using "e" and 0
        persons[num-1].s_name=names[2];
        persons[num-1].c_number=nums[1];
        persons[num-1].g_number=nums[0];

        input.nextLine();

        System.out.print("Enter Q for Exit: ");//quit main menu
        String com = input.nextLine();
        if (com.equals("q")||com.equals("Q")){
            main_menu(del,persons,queue_str,queue_num); //calling main_menu
        }else{
            deleteCustomer(del,persons,queue_str,queue_num);
        }
    }
    public static void findCustomer(Room[] find,Person[] persons,Queue_Str queue_str,Queue_Num queue_num){
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("   --Find_Room_from_Customer_name--"); //message given to the user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name you want to find the name: ");
        String name = input.nextLine();//room to find input
        int temp=0;
        for (int x=0;x<8;x++) {
            if (name.equals(find[x].name)) {
                System.out.println(name + "booking in room num : " + (x + 1));
                temp += 1;
            }
        }
        if(temp==0){
            System.out.println("Can't Find");

        }
        System.out.print("Enter Q for Exit: ");//quit main menu
        String com = input.nextLine();
        if (com.equals("q")){
            main_menu(find,persons,queue_str,queue_num); //calling main_menu
        }else{
            findCustomer(find,persons,queue_str,queue_num);
        }
    }
    public static void storeData(Room[] store,Person[] persons, Queue_Str queue_str,Queue_Num queue_num){
        try {
            FileWriter sWriter = new FileWriter("details.txt");// file printing is output.txt
            for(int x=0;x<8;x++){
                sWriter.write("Room Number "+(x+1)+" got "+ store[x].name+"\n"); //passing room name to store details
                sWriter.write("First Name        :  "+ persons[x].f_name+"\n");
                sWriter.write("Surname           :  "+ persons[x].s_name+"\n");
                sWriter.write("Number of Guests  :  "+ persons[x].g_number+"\n");
                sWriter.write("Credit Card Number:  "+ persons[x].c_number+"\n\n");

            }
            sWriter.close();
            System.out.println("Store to the file.");
        } catch (IOException e) {
            System.out.println("Error Detected.");
            e.printStackTrace();
        }
        main_menu(store,persons,queue_str,queue_num); //calling main_menu
    }

    public static void loadData(Room[] load,Person[] persons,Queue_Str queue_str, Queue_Num queue_num){
        try {
            File load_file = new File("load.txt");//load.txt is taken
            Scanner myReader = new Scanner(load_file);//
            String[] ld; //make a array named split
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ld=data.split("-");//split by "-"
                int room_number = Integer.parseInt(ld[0])-1;
                load[room_number].name=ld[1]; //data taken from load.txt
                persons[room_number].f_name=ld[2]; //data taken from load.txt
                persons[room_number].s_name=ld[3]; //data taken from load.txt
                persons[room_number].g_number=Integer.parseInt(ld[4]); //data taken from load.txt
                persons[room_number].c_number=Integer.parseInt(ld[5]); //data taken from load.txt
            }
            myReader.close();
        } catch (FileNotFoundException e) {// error handling part
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        main_menu(load,persons, queue_str, queue_num); //calling main_menu
    }

   /* public static void orderAlphabetically(Room[] order,Person[] persons){

    }*/
}


