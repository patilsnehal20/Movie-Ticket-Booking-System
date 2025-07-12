package MovieTicketBookingSystem;

import java.util.*;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) 
    {
        //ANSIcodesfordifferentcolors
        String ANSI_MAGENTA = "\u001B[95m";
        String ANSI_RESET = "\u001B[0m";
        String PINK = "\u001B[95;1m";
        String Lilac = "\u001B[95m";
        String palegreen = "\u001B[97m";
        String pink2 = "\u001B[95;1;97m";
        System.out.println(Lilac + "*************WELCOME TO BOOK MY SHOW**************" + ANSI_RESET);
        //object of movie class giving reference to booking
        Booking m = new movie();
        m.list();
    }
}

//creating interference
interface Booking 
{
    void list();
    void choose_movie();
    void Date();
    void theatre();
    int slot();
}

class Theatre 
{
    String name;
    String location;
    String info;
    Theatre(String name, String location, String info) 
    {
        this.name = name;
        this.location = location;
        this.info = info;
    }
    String getName() 
    {
        return name;
    }
    String getLocation() 
    {
        return location;
    }
    String getInfo() 
    {
        return info;
    }
}

//creating class which implements booking
class movie implements Booking 
{	
    //use of encapsulation by making variables private
    private int slot;
    private String name1;
    private long number;
    private String fb;
    private int c, ch;
    private int cho;
    private static int numSeats;
    private char category[] = new char[124];
    private int row[] = new int[124];
    private int seat[] = new int[124];
    String PINK = "\u001B[95m";
    String ANSI_RESET = "\u001B[0m";
    String ANSI_UNDERLINE = "\u001B[4m";
    String ANSI_BOLD = "\u001B[1m";
    String ANSI_Cyan = "\u001B[36m";
    String ANSI_MAGENTA = "\u001B[35m";
    String LIGHT_GREEN = "\u001B[92m";
    String Lilac = "\u001B[95m";
    String Skyblue = "\u001B[96m";
    String b = "\u001B[94m";
    ArrayList < String > name = new ArrayList < > ();
    ArrayList < String > type = new ArrayList < > ();
    ArrayList < String > dates = new ArrayList < > ();
    ArrayList < Theatre > theatres = new ArrayList < > ();
    private int snacks, k, m;
    private String SnackName;
    private double gst, h;
    private double pay = 0;
    private int q[] = new int[10];
    private double total[] = new double[10];
    ArrayList < String > beverages = new ArrayList < String > ();
    ArrayList < String > Snack = new ArrayList < String > ();
    ArrayList < Double > price = new ArrayList < Double > ();
    ArrayList < Double > PRICE = new ArrayList < Double > ();
    ArrayList < Integer > sNo = new ArrayList < Integer > ();
    private double ticket[] = new double[10];
    private double cash, payment = 0, paym;
    Scanner sc = new Scanner(System.in);
    public void list() 
    {
        boolean validPhoneNumber = false;
        boolean validName = false;
        Scanner sc = new Scanner(System.in);
        while (!validName) 
        {
            System.out.print("Please enter your name:");
            name1 = sc.nextLine();
            //Validate the name to contain only alphabetic characters
            if (name1.matches("[a-zA-Z]+")) 
            {
                break; //Exit the loop if a valid name is entered
            } else {
                System.out.println("Error:Name must contain only alphabet or characters.");
            }
        }
        while (!validPhoneNumber) 
        {
            try {
                System.out.print("Please enter mobile number:");
                long number = sc.nextLong();
                //ConvertnumbertoStringtocountdigits
                String numberString = Long.toString(number);
                //Check if phone number is 10 digits and starts with 7,8,or 9
                if (numberString.length() != 10) 
                {
                    throw new IllegalArgumentException("Phone number must be 10 digits long.");
                }
                //check if phone number starts from 7,8 and 9 only
                if (numberString.charAt(0) != '7' && numberString.charAt(0) != '8' &&
                    numberString.charAt(0) != '9')
                {
                    throw new IllegalArgumentException("Phone number must start with7,8,or9.");
                }
                validPhoneNumber = true;
            } catch (InputMismatchException e) 
            {
                System.out.println("Error:Please enter a valid integer for phone number.");
                sc.nextLine(); //Consume invalid input to avoid infinite loop
            } catch (IllegalArgumentException e) 
            {
                System.out.println("Error:" + e.getMessage());
            }
        }
        System.out.println("\nHi" + name1 + "!!What would you like to watch?\n");
        //adding movie names to arraylist
        name.add(ANSI_UNDERLINE + Skyblue + "Crew" + ANSI_RESET);
        name.add(ANSI_UNDERLINE + Skyblue + "Godzilla x Kong:The New Empire" + ANSI_RESET);
        name.add(ANSI_UNDERLINE + Skyblue + "Swatantrya Veer Savarkar" + ANSI_RESET);
        name.add(ANSI_UNDERLINE + Skyblue + "Shaitaan" + ANSI_RESET);
        name.add(ANSI_UNDERLINE + Skyblue + "Madgaon Express" + ANSI_RESET);
        name.add(ANSI_UNDERLINE + Skyblue + "Alibaba Ani Chalishitale Chor" + ANSI_RESET);
        name.add(ANSI_UNDERLINE + Skyblue + "Kung Fu Panda4" + ANSI_RESET);
        name.add(ANSI_UNDERLINE + Skyblue + "Article 370" + ANSI_RESET);
        name.add(ANSI_UNDERLINE + Skyblue + "Yodha" + ANSI_RESET);
        name.add(ANSI_UNDERLINE + Skyblue + "Aadujeevitham - The Goat Life" + ANSI_RESET);
        
        //adding movie genres
        type.add("Comedy,Thriller");
        type.add("Action,Sci-Fi,Thriller");
        type.add("Biography,Drama");
        type.add("Supernatural,Thriller");
        type.add("Comedy,drama");
        type.add("Comedy,Mystery");
        type.add("Action,Animation,Adventure,Comedy");
        type.add("Drama,Political");
        type.add("Action,Thriller");
        type.add("Adventure,Drama");
        for (int i = 0; i < name.size(); i++)
        {
            System.out.println(Skyblue + (i + 1) + "." + name.get(i) + "\n" + type.get(i) + "\n" + ANSI_RESET);
        }
        choose_movie();
    }
    
    public void choose_movie() 
    {
        do {
            System.out.print("Enter the serial number of movie to get discription:");
            c = sc.nextInt();
            //cases for movie description
            switch (c) 
            {
                case 1:
                    System.out.println(name.get(0));
                    System.out.println("2D" + "" + "Hindi");
                    System.out.println("2h4m-" + type.get(0));
                    System.out.println("CAST:\nTabu-as Geeta\nKareena Kapoor Khan-as Jasmine\nKriti Sanon-as Divya\n");
                    System.out.println("Book ticket?\n1.Yes\n2.No");
                    int ch1 = sc.nextInt();
                    if (ch1 == 1) 
                    {
                        Date();
                    }
                    break;
                case 2:
                    System.out.println(name.get(1));
                    System.out.println("2D" + "" + "Hindi,English,Telugu,Tamil");
                    System.out.println("1h54m-" + type.get(1));
                    System.out.println("CAST:\nRebecca Hall\nBerian Henry\nKaylee Hottle\n");
                    System.out.println("Book ticket?\n1.Yes\n2.No");
                    int ch2 = sc.nextInt();
                    if (ch2 == 1) 
                    {
                        Date();
                    }
                    break;
                case 3:
                    System.out.println(name.get(2));
                    System.out.println("2D" + "" + "Hindi,Marathi");
                    System.out.println("2h58m-" + type.get(2));
                    System.out.println("CAST:\nRandeep Hooda-as Vinayak Damodar Savarkar\nAnkita Lokhande-as Yamuna\n");
                    System.out.println("Book ticket?\n1.Yes\n2.No");
                    int ch3 = sc.nextInt();
                    if (ch3 == 1) 
                    {
                        Date();
                    }
                    break;
                case 4:
                    System.out.println(name.get(3));
                    System.out.println("2D,ICE" + "" + "Hindi");
                    System.out.println("2h12m-" + type.get(3));
                    System.out.println("CAST:\nAjay Devgn-asKabir\nR.Madhavan-as Vanraj\nJyotika Sadanah-as Jyoti\n");
                    System.out.println("Book ticket?\n1.Yes\n2.No");
                    int ch4 = sc.nextInt();
                    if (ch4 == 1) 
                    {
                        Date();
                    }
                    break;
                case 5:
                    System.out.println(name.get(4));
                    System.out.println("2D" + "" + "Hindi");
                    System.out.println("2h25m-" + type.get(4));
                    System.out.println("CAST:\nPratikandhi-as Pinku\nDivyendu Sharma-as dodo\nNora Fatehi-as Tasha\nAvinash Tiwari-as Ayush\n");
                    System.out.println("Book ticket?\n1.Yes\n2.No");
                    int ch5 = sc.nextInt();
                    if (ch5 == 1) 
                    {
                        Date();
                    }
                    break;
                case 6:
                    System.out.println(name.get(5));
                    System.out.println("2D" + "" + "Marathi");
                    System.out.println("2h5m-" + type.get(5));
                    System.out.println("CAST:\nSubodh\nAtul Parchure\nAnand Ingale\nMukta Barve\n");
                    System.out.println("Book ticket?\n1.Yes\n2.No");
                    int ch6 = sc.nextInt();
                    if (ch6 == 1)
                    {
                        Date();
                    }
                    break;
                case 7:
                    System.out.println(name.get(6));
                    System.out.println("2D" + "" + "Hindi,English,Telugu,Tamil");
                    System.out.println("1h33m-" + type.get(6));
                    System.out.println("CAST:\nJack Black-as Po\nAwkwafina-as Zhen\nViola Davis-as Chameleon\n");
                    System.out.println("Bookticket?\n1.Yes\n2.No");
                    int ch7 = sc.nextInt();
                    if (ch7 == 1) 
                    {
                        Date();
                    }
                    break;
                case 8:
                    System.out.println(name.get(7));
                    System.out.println("2D" + "" + "Hindi");
                    System.out.println("2h40m-" + type.get(7));
                    System.out.println("CAST:\nYami Gautam-as Zooni Haksar\nArun Govil-as Prime minister\nVaibhav Tatwawdi-as Yash Chauhan\n");
                    System.out.println("Book ticket?\n1.Yes\n2.No");
                    int ch8 = sc.nextInt();
                    if (ch8 == 1) 
                    {
                        Date();
                    }
                    break;
                case 9:
                    System.out.println(name.get(8));
                    System.out.println("2D" + "" + "Hindi");
                    System.out.println("2h13m-" + type.get(7));
                    System.out.println("CAST:\nSiddhart Malotra-as Arun Katyal\nRashi Khan\nDisha Patani\n");
                    System.out.println("Book ticket?\n1.Yes\n2.No");
                    int ch9 = sc.nextInt();
                    if (ch9 == 1) 
                    {
                        Date();
                    }
                    break;
                case 10:
                    System.out.println(name.get(9));
                    System.out.println("2D" + "" + "Hindi,Tamil,Kannada,Malayalam,Telugu");
                    System.out.println("2h53m-" + type.get(9));
                    System.out.println("CAST:\nPritviraj Sukumaran-as Najeeb\nAmala Paul-as Sainu\nK.R.Gokul-as Hakkim\n");
                    System.out.println("Book ticket?\n1.Yes\n2.No");
                    int ch10 = sc.nextInt();
                    if (ch10 == 1) 
                    {
                        //slot();
                        Date();
                    }
                    break;
            }
        } while (c != 10);
    }
    
    public void Date() 
    {
        //adding dates to arraylist
        dates.add("Sat,20April");
        dates.add("Sun,21April");
        dates.add("Mon,22April");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Select the date for the movie:");
            for (int i = 0; i < dates.size(); i++) 
            {
                System.out.print((i + 1) + ")" + dates.get(i) + "\n");
            }
            cho = sc.nextInt();
            if (cho >= 1 && cho <= dates.size()) 
            {
                System.out.println("The day you selected is:" + dates.get(cho - 1) + "\n");
                theatre();
            }
        } while (cho != 3);
    }
    
    public void theatre() 
    {
        Scanner sc = new Scanner(System.in);
        theatres.add(new Theatre("City Pride", "Kothrud", "SurveyNo.20/1,2,Kothrud,Near Tara Residency,Pune,Maharashtra 411038, India"));
        theatres.add(new Theatre("Fun Time Multiplex", "Sinhagad Road", "Near Manik Baug Petrol Pump,Sinhagad Road,Pune,Maharashtra 411041, India"));
        theatres.add(new Theatre("Rahul 70MM", "Shivajinagar", "Ganeshkhind Road,Shivajinagar,Narveer Tanaji Wadi,Pune,Maharashtra 411004, India"));
        theatres.add(new Theatre("Ashok Theatre", "Pimpri", "Shastri Nagar,Pimpri Colony,Pune,Maharashtra 411017,India"));
        do {
            System.out.println("Enter serial number of theater to get address of theater:");
            for (int i = 0; i < theatres.size(); i++) 
            {
                System.out.println((i + 1) + ")" + theatres.get(i).getName() + ":" + theatres.get(i).getLocation());
            }
            ch = sc.nextInt();
            if (ch < 1 || ch > theatres.size()) 
            {
                System.out.println("Invalid choice. Please enter a valid serial number.");
            } else 
            {
                System.out.println(theatres.get(ch - 1).getInfo());
                System.out.println("\nWould you like to confirm this theater?\n1)Yes\n2)No");
                int t = sc.nextInt();
                if (t == 1) 
                {
                    System.out.println("Selected theater is:" + theatres.get(ch - 1).getName() + ":" + theatres.get(ch - 1).getLocation() + "\n");
                    slot();
                }
            }
        } while (ch != 0);
    }
    
    public int slot() 
    {
        do {
            System.out.println("Select the slot!");
            System.out.println("1)9AM\n2)12:30PM\n3)3PM\n4)6:30PM\n5)9PM");
            slot = sc.nextInt();
            switch (slot) 
            {
                case 1:
                    try 
                    {
                        slot2(slot);
                    } catch (InsufficientTicketException e) 
                    {
                        //Handle insufficient ticket exception
                        System.out.println("Error:" + e.getMessage());
                    }
                    return 1;
                case 2:
                    try 
                    {
                        slot2(slot);
                    } catch (InsufficientTicketException e)
                    {
                        //Handle insufficient ticket exception
                        System.out.println("Error:" + e.getMessage());
                    }
                    return 2;
                case 3:
                    try 
                    {
                        slot2(slot);
                    } catch (InsufficientTicketException e) 
                    {
                    	//Handle insufficient ticket exception
                        System.out.println("Error:" + e.getMessage());
                    }
                    return 3;
                case 4:
                    try 
                    {
                        slot2(slot);
                    } catch (InsufficientTicketException e) 
                    {
                    	//Handle insufficient ticket exception
                        System.out.println("Error:" + e.getMessage());
                    }
                    return 4;
                case 5:
                    try 
                    {
                        slot2(slot);
                    } catch (InsufficientTicketException e) 
                    {
                    	//Handle insufficient ticket exception
                        System.out.println("Error:" + e.getMessage());
                    }
                    return 5;
                default:
                    System.out.println("Enter valid slot number");
            }
        } while (true);
    }
    
    public void slot2(int slot) 
    {
        String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";
        String ANSI_RESET = "\u001B[0m";
        boolean validCategory = false;
        
        //print seat matrix
        System.out.println("ROYAL PLATINUM RS.300");
        char[][] seatsA = printSeats('A', 2, 13);
        System.out.println("\nROYALGOLDRS.250");
        char[][] seatsB = printSeats('B', 8, 9);
        System.out.println("\nROYALSILVERRS.180");
        char[][] seatsC = printSeats('C', 2, 13);
        System.out.println("\n\t_________________________\n\t" + BLUE_BACKGROUND_BRIGHT + "          SCREEN         " + ANSI_RESET + "\t\n\t" + BLUE_BACKGROUND_BRIGHT + "_________________________" + ANSI_RESET + "\t\t");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many seats do you want to select?");
        numSeats = scanner.nextInt();
        
        //choose the category
        if (numSeats > 124) 
        {
            throw new InsufficientTicketException("Insufficient tickets available for these selected movie and theatre!");
        }
        for (int i = 0; i < numSeats; i++) 
        {
            //Keep prompting until a valid category is entered
            while (true) 
            {
                System.out.print("Enter seat category (A,B,C) for seat" + (i + 1) + ":");
                char inputCategory = scanner.next().charAt(0);
                //Check if the entered category is valid
                if (inputCategory == 'A' || inputCategory == 'B' || inputCategory == 'C') 
                {
                    category[i] = inputCategory;
                    break; //Exit the loop if a valid category is entered
                } else 
                {
                    System.out.println("Error: Invalid seat category. Please enter A, B, or C.");
                }
            }
            
            //Rest of your code remains unchanged
            System.out.print("Enter row number for seat" + (i + 1) + ":");
            row[i] = scanner.nextInt();
            System.out.print("Enter seat number for seat" + (i + 1) + ":");
            seat[i] = scanner.nextInt();
            replaceSeat(category[i], row[i], seat[i], seatsA, seatsB, seatsC);
        }
        beverages();
    }
    
    public static char[][] printSeats(char category, int rows, int seats) 
    {
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";
        String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";
        char[][] seatsArray = new char[rows][seats];
        for (int i = 0; i < rows; i++) 
        {
            if (category == 66) 
            {
                System.out.print(category + "" + (i + 1) + " ");
            } else {
                System.out.print(category + "" + (i + 1) + "");
            }
            for (int j = 0; j < seats; j++) 
            {
                seatsArray[i][j] = category;
                System.out.print("[" + ANSI_GREEN + (j + 1) + ANSI_RESET + "]");
            }
            System.out.println();
        }
        return seatsArray;
    }
    
    public static void replaceSeat(char category, int row, int seat, char[][] seatsA, char[][] seatsB, char[][] seatsC) 
    {
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";
        String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";
        switch (category)
        {
            case 'A':
                if(seatsA[row - 1][seat - 1] == 'X')
                {
                    System.out.println("Sorry! This seat is already booked!\n");
                    numSeats--;
                    break;
                } else{
                    seatsA[row - 1][seat - 1] = 'X';
                }
                break;
            case 'B':
                if(seatsB[row - 1][seat - 1] == 'X')
                {
                    System.out.println("Sorry! This seat is already booked!\n");
                    numSeats--;
                    break;
                } else{
                    seatsB[row - 1][seat - 1] = 'X';
                }
                break;
            case 'C':
                if(seatsC[row - 1][seat - 1] == 'X')
                {
                    System.out.println("Sorry! This seat is already booked!\n");
                    numSeats--;
                    break;
                } else{
                    seatsC[row - 1][seat - 1] = 'X';
                }
                break;
            default:
                System.out.println("Invalid category.");
                return;
        }
        System.out.println("ROYAL PLATINUM RS.300");
        printUpdatedSeats('A', seatsA);
        System.out.println("\nROYAL GOLD RS.250");
        printUpdatedSeats('B', seatsB);
        System.out.println("\nROYAL SILVER RS.180");
        printUpdatedSeats('C', seatsC);
        System.out.println("\n\t_________________________\n\t" + BLUE_BACKGROUND_BRIGHT + "          SCREEN         " + ANSI_RESET + "\t\n\t" + BLUE_BACKGROUND_BRIGHT + "_________________________" + ANSI_RESET + "\t\t");
        System.out.println();
        System.out.println("||" + ANSI_RED + "X" + ANSI_RESET + "represents booked seats||.\n");
    }
    
    public static void printUpdatedSeats(char category, char[][] seats) 
    {
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";
        String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";
        for (int i = 0; i < seats.length; i++) 
        {
            if (category == 66) 
            {
                System.out.print(category + "" + (i + 1) + " ");
            } else {
                System.out.print(category + "" + (i + 1) + "");
            }
            for (int j = 0; j < seats[i].length; j++) 
            {
                if (seats[i][j] == 'X') 
                {
                    System.out.print("[" + ANSI_RED + "X" + ANSI_RESET + "]");
                } else {
                    System.out.print("[" + ANSI_GREEN + (j + 1) + ANSI_RESET + "]");
                }
            }
            System.out.println();
        }
    }
    
    //beverages();
    void beverages() 
    {
        //display menu card
        System.out.println("\n********SNACK MENU CARD********\n");
        System.out.println();
        System.out.println("SN0. MENU \t\tPRICE");
        System.out.println("1. FINGERCHIPS  \t100.00Rs.");
        System.out.println("2. POPCORNS  \t\t50.00Rs.");
        System.out.println("3. SPRINGROLL  \t\t80.00Rs.");
        System.out.println("4. COLD-COFFEE  \t70.00Rs.");
        System.out.println("5. COCA-COLA  \t\t60.00Rs.");
        System.out.println("6. WATER BOTTLE \t30.00Rs.");
        
        //add menu to arraylist
        beverages.add("FINGERCHIPS");
        price.add(100.00);
        sNo.add(1);
        beverages.add("POPCORNS");
        price.add(50.00);
        sNo.add(2);
        beverages.add("SPRINGROLL");
        price.add(80.00);
        sNo.add(3);
        beverages.add("COLD-COFFEE");
        price.add(70.00);
        sNo.add(4);
        beverages.add("COCA-COLA");
        price.add(60.00);
        sNo.add(5);
        beverages.add("WATER BOTTLE");
        price.add(30.00);
        sNo.add(6);
        System.out.println();
        System.out.println("Do you want any snacks or beverages?\n1.YES\n2.NO");
        snacks = sc.nextInt();
        if (snacks == 1) 
        {
            bill();
        } else {
            payment();
        }
    }
    
    void bill() 
    {
        System.out.print("Enter the no.of snacks items you want :");
        k = sc.nextInt();
        for (int i = 0; i < k; i++) 
        {
            System.out.print("Enter the serial no. :");
            m = sc.nextInt();
            Snack.add(beverages.get(m - 1));
            PRICE.add(price.get(m - 1));
            System.out.print("Enter the quantity:");
            q[i] = sc.nextInt();
            for (int j = 0; j < beverages.size(); j++)
            {
                if (m == j + 1) 
                {
                    h = (q[i] * price.get(j));
                    gst = h * 12 / 100;
                    break;
                }
            }
            total[i] = h + gst;
        }
        System.out.println();
        
        //printBill
        System.out.println("********TAX INVOICE*******\n");
        System.out.println("Customer :" + name1);
        System.out.println("SNo. \tSNACKS  \t\tPRICE\t\tQty\t\tTotal");
        for (int i = 0; i < k; i++) 
        {
            System.out.print(sNo.get(i));
            System.out.print("\t");
            System.out.print(Snack.get(i));
            System.out.print("\t\t");
            System.out.print(PRICE.get(i));
            System.out.print("\t\t");
            System.out.print(q[i]);
            System.out.print("\t\t");
            System.out.println(total[i]);
            pay = pay + (total[i]);
        }
        System.out.println();
        System.out.println("NET:" + pay + "Rs.");
        System.out.println("THANK YOU!");
        payment();
    }
    
    void payment() 
    {
        for (int i = 0; i < numSeats; i++) 
        {
            if (category[i] == 65) 
            {
                ticket[i] = 300;
            } else if (category[i] == 66) {
                ticket[i] = 250;
            } else if (category[i] == 67) {
                ticket[i] = 180;
            }
            payment = payment + ticket[i];
        }
        paym = payment + pay;
        System.out.println();
        System.out.println("Your total price of snacks and beverages is :" + paym);
        int c;
        boolean couponApplied = false;
        do {
            System.out.println("Do you want to apply any coupons for extra offers?\n1)Yes\n2)Skip\n");
            c = sc.nextInt();
            switch (c) 
            {
                case 1:
                    System.out.println("Enter the coupon code");
                    String couponCode = sc.next();
                    if (!couponApplied)
                    {
                        //Apply discount only if a coupon hasn't been applied yet
                        if (couponCode.equals("TAKE100")) 
                        {
                            paym -= 0.1 * paym;
                            paym = (int) paym;
                            System.out.println("Great!!10% discount offer is applied successfully");
                            System.out.println("Amount to pay after application of offers:" + paym);
                            couponApplied = true;     //Mark the coupon as applied
                        } else if (couponCode.equals("MYSHOW123")) {
                            paym -= 0.12 * paym;
                            paym = (int) paym;
                            System.out.println("Great!!12% discount offer is applied successfully");
                            System.out.println("Amount to pay after application of offers:" + paym);
                            couponApplied = true;     //Mark the coupon as applied
                        } else if (couponCode.equals("Y2CJ3")) {
                            paym -= 0.15 * paym;
                            paym = (int) paym;
                            System.out.println("Great!!15% discount offer is applied successfully");
                            System.out.println("Amount to pay after application of offers:" + paym);
                            couponApplied = true;     //Mark the coupon as applied
                        } else if (couponCode.equals("OFF3R")) {
                            paym -= 0.18 * paym;
                            paym = (int) paym;
                            System.out.println("Great!!18% discount offer is applied successfully");
                            System.out.println("Amount to pay after application of offers:" + paym);
                            couponApplied = true;     //Mark the coupon as applied
                        } else {
                            System.out.println("Sorry, this coupon doesn't work!Try another.");
                        }
                    } else {
                        System.out.println("Sorry,only ONE coupon can be applied on a booking");
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Skipping coupon application.");
                    break;
                default:
                    System.out.println("Invalid option.Please enter 1 or 2.");
            }
        } while (c != 2);
        boolean validcash = false;
        while (!validcash) 
        {
            try {
                System.out.print("Please enter cash amount:");
                cash = sc.nextDouble();
                validcash = true;
            } catch (InputMismatchException e) 
            {
                System.out.println("Error:Please enter a valid double for cash amount.");
                sc.next(); //Clear the invalid input
            }
        }
        cash = (int) cash;
        double returnAmount = 0;
        while (cash < paym) 
        {
            System.out.println("INSUFFICIENT MONEY!");
            System.out.println("You should pay " + (paym - cash) + "Rs. more!");
            System.out.print("Input cash:");
            double cashInput = sc.nextDouble();
            if (cashInput > (paym - cash)) 
            {
                returnAmount = cashInput - (paym - cash);
                if (returnAmount != 0) 
                {
                    System.out.println(returnAmount + "Rs.returned!");
                    cash += (paym - cash);
                    System.out.println("Payment has been successfully done! \nTHANK YOU!");
                    ticket(theatres.get(ch - 1).getName());
                    break; //Exit the loop as payment is complete
                }
            } else {
                cash += cashInput;
            }
        }
        if (returnAmount == 0.0) 
        {
            if (cash >= paym) 
            {
                returnAmount = cash - paym;
                System.out.println(returnAmount + "Rs.returned!And Payment has been successfully done! \nTHANK YOU!");
            }
            ticket(theatres.get(ch - 1).getName());
        }
    }
    
    void ticket(String theatreName) 
    {
        //printing ticket
        System.out.println("\n********TICKET********\n");
        for (int i = 0; i < name.size(); i++) 
        {
            if (c == i + 1) 
            {
                System.out.println(name.get(i));
            }
        }
        System.out.print(dates.get(cho - 1) + "|");
        if (slot == 1) 
        {
            System.out.print("9AM\n");
        } else if (slot == 2) {
            System.out.print("12.30PM\n");
        } else if (slot == 3) {
            System.out.print("3PM\n");
        } else if (slot == 4) {
            System.out.print("6.30PM\n");
        } else if (slot == 5) {
            System.out.print("9PM\n");
        }
        System.out.println(theatreName + "\n");
        System.out.println(numSeats + "ticket(s)");
        System.out.println("SCREEN2");
        for (int i = 0; i < numSeats; i++) 
        {
            if (category[i] == 65) 
            {
                System.out.print("PLATINUM-");
            } else if (category[i] == 66) 
            {
                System.out.print("GOLD-");
            } else if (category[i] == 67) 
            {
                System.out.print("SILVER-");
            }
            System.out.println(category[i] + "" + row[i] + "-" + seat[i] + "");
        }
        
        //checking conditions for coupons
        if (paym >= 800 && paym < 1000) 
        {
            System.out.println("\n\nHooray!!!You got a coupon code\n" + LIGHT_GREEN + "TAKE100" + ANSI_RESET + "\nSave this coupon code and apply this coupon to your next booking to get 10% discount.");
            cancel();
        } else if (paym >= 1000 && paym < 1200) {
            System.out.println("\n\nHooray!!!You got a coupon code\n" + LIGHT_GREEN + "MYSHOW123" + ANSI_RESET + "\nSave this coupon code and apply this coupon to your next booking to get 12% discount.");
            cancel();
        } else if (paym >= 1200 && paym < 1500) {
            System.out.println("\n\nHooray!!!You got a coupon code\n" + LIGHT_GREEN + "Y2CJ3" + ANSI_RESET + "\nSave this coupon code and apply this coupon to your next booking to get 15% discount.");
            cancel();
        } else if (paym >= 1500) {
            System.out.println("\n\nHooray!!!You got a coupon code\n" + LIGHT_GREEN + "OFF3R" + ANSI_RESET + "\nSave this coupon code and apply this coupon to your next booking to get 18% discount.");
            cancel();
        } else {
            cancel();
        }
    }
    
    int cancel() 
    {
        int c;
        do {
            System.out.println("\nDo you want to cancel the booking?\n1)Yes\n2)No");
            c = sc.nextInt();
            switch (c) 
            {
                case 1:
                    cancel2();
                    return 1;
                case 2:
                    System.out.println("Thank you for booking your movie tickets with us!We hope you enjoy your booking experience.");
                    end();
                    return 2;
                default:
                    System.out.println("Enter valid option");
            }
        } while (c != 0);
        return c;
    }
    
    void cancel2() 
    {
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";
        String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";
        
        //displaying updated seat matrix
        System.out.println("Canceled successfully");
        System.out.println("The updated seat matrix:\n");
        System.out.println("ROYAL PLATINUM RS.300");
        for (int i = 1; i < 3; i++) 
        {
            System.out.print("A" + i + "");
            for (int j = 1; j < 14; j++) 
            {
                System.out.print("[" + ANSI_GREEN + j + ANSI_RESET + "]");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("ROYAL GOLD RS.250");
        for (int i = 1; i < 9; i++) 
        {
            System.out.print("B" + i + " ");
            for (int j = 1; j < 10; j++) 
            {
                System.out.print("[" + ANSI_GREEN + j + ANSI_RESET + "]");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("ROYALS ILVER RS.180");
        for (int i = 1; i < 3; i++) 
        {
            System.out.print("C" + i + "");
            for (int j = 1; j < 14; j++) 
            {
                System.out.print("[" + ANSI_GREEN + j + ANSI_RESET + "]");
            }
            System.out.println();
        }
        System.out.println("\n\t_________________________\n\t" + BLUE_BACKGROUND_BRIGHT + "          SCREEN         " + ANSI_RESET + "\t\n\t" + BLUE_BACKGROUND_BRIGHT + "_________________________" + ANSI_RESET + "\t\t");
        System.out.println();
        
        //make this blue
        System.out.println("Refund has been done successfully!!\nCan you tell the reason for the cancellation:\n1.Dissatisfaction with the movie selection showtime\n2.Schedule conflict\n3.Better entertainment options or alternatives arising\n4.Other.");
        //see the problem with next line
        int ch = sc.nextInt();
        switch (ch) 
        {
            case 1:
                System.out.println("Ohh sorry to hear that.Thanks for the valuable feedback!\nWe will work on our system.");
                end();
                break;
            case 2:
                System.out.println("Ohh sorry to hear that.Thanks for the valuable feedback!\nWe will work on our system.");
                end();
                break;
            case 3:
                System.out.println("Ohh sorry to hear that.Thanks for the valuable feedback!\nWe will work on our system.");
                end();
                break;
            case 4:
                System.out.print("Please enter the reason:");
                fb = sc.next();
                System.out.print("Customer feedback:" + fb + "\n");
                System.out.print("Thanks for the valuable feedback!\nWe will work on our system.\n");
                end();
        }
    }
    
    void end() 
    {
        System.out.println("Your feedback matters to us.Please take a moment to rate your experience on a scale of 1 to 5,");
        System.out.println("where 1 represents 'dissatisfactory' and 5 represents 'excellent'.");
        System.out.println("We appreciate your input!\n\n");
        int rating;
        boolean validRating = false;
        do {
            //Ask for feedback rating
            System.out.print("Please rate your experience(1to5):");
            rating = sc.nextInt();
            //Validate rating
            if (rating >= 1 && rating <= 5) 
            {
                validRating = true;
            } else {
                System.out.println("Invalid rating!Please rate your experience on a scale of 1 to 5.");
            }
        } while (!validRating);
        System.out.println("Thank you for your feedback!");
        
        //Ask for improvement suggestions if rating is not excellent(5)
        if (rating < 5) 
        {
            System.out.println("\n\nWe value your opinion! \nPlease share how we can improve our service further:");
            sc.nextLine(); //Consume new line character leftbynextInt()
            String improvementSuggestion = sc.nextLine();
            System.out.println("Thank you for your valuable feedback. We will strive to implement your suggestions!");
        }
        System.exit(0);
    }
}

class InsufficientTicketException extends RuntimeException {
    public InsufficientTicketException(String message) {
        super(message);
    }
}