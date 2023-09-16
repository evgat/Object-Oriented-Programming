import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class SocialNetwork
{
    public static void main(String[] args) throws ParseException, NonFriendException, FriendsException, SelfException, AlreadyLikedException //i dilosi throws simenei oti to main kathw ekteleitai mporei na prokalesei tous aklouthous tipous eksairesewn.
    { 
        User user1 = new User("mail1", "first1","last1");
        Network.addUser(user1);
    
        User user2 = new User("mail2", "first2","last2");
        Network.addUser(user2);
  
        User user3 = new User("mail3", "first3","last3");
        Network.addUser(user3);
        
        User user4 = new User("mail4", "first4","last4");
        Network.addUser(user4);
        
        User user5 = new User("mail5", "first5","last5");
        Network.addUser(user5);
        
        User user6 = new User("mail6", "first6","last6");
        Network.addUser(user6);
    
        User user7 = new User("mail7", "first7","last7");
        Network.addUser(user7);
    
        User user8 = new User("mail8", "first8","last8");
        Network.addUser(user8);
        
        
    	Network.becomeFriends(user1, user3);
    	//Network.becomeFriends(user2, user1);
    	Network.becomeFriends(user3, user5);
    	
        boolean connected;
        do
        {
            connected = connectWithApp();//epistrefetai true an o xristis dwsei swto email allios epistrefetai faulse 
        } while(!connected);//oso to connected einai faulse ektelei vrongxo.
       
        int userchoice;
        do{//edw ekteleitai epanaliptika to MENU.
            Menu.main();//i sinarisi main emfanizei to menu me tis 8 epiloges.
            System.out.println("");
                
            do
            {
                System.out.println("Select(1-8)");
                    userchoice = makeAChoice();
                    
                if(userchoice < 1 || userchoice > 8)
                {
                    System.out.println("The choice has to be from 1 to 8");
                }
            } while(userchoice < 1 || userchoice > 8);
    
    
            if(userchoice == 1)
            {
                Menu.choice1();
            }
            else if(userchoice == 2)
            {
                Menu.userFriends();//typwnontai sthn othoni oi friends tou user pou exei kanei login gia na epilejoume auton pou tha epilejoume(1-3)
                System.out.println("");
                int ch2;
                
                if(Network.getFriends(Network.getUserConnected()).length > 0)//an isxyei h sinthiki o user pou exei kanei login exei filous
                {
                    do
                    {
                        System.out.println("Select(1-"+Network.getFriends(Network.getUserConnected()).length+")");
                        ch2 = makeAChoice();
                        
                        if(ch2 < 1 || ch2 > Network.getFriends(Network.getUserConnected()).length)
                        {
                            System.out.println("The choice has to be from 1 to "+Network.getFriends(Network.getUserConnected()).length);
                        }
                    } while(ch2 < 1 || ch2 > Network.getFriends(Network.getUserConnected()).length);
                    
                    User use = Network.getFriends(Network.getUserConnected())[ch2 - 1];/*prwta epilegetai o user pou exei kanei login kalwntas th synartisi Network.getUserConnected()
                    sth synexeia kaleitai h synartisi Network.getFriends pou lamvanei san orisma to xristi auton kai epistrefei ena arraylist me tous filous tou.telos apo auto to arraylist
                    epilegoume ton friend pou einai sth thesi ch2-1 opou ch2 h epilogh pou exoume kanei apo th lista twn emfanizomenwn filwn.to -1 mpainei gt to arraylist aarithmeitai apo to 0.*/
                    Menu.choice2(use);
                    do
                    {
                        System.out.println("Select(1-3)");
                        ch2 = makeAChoice(); 
                        if(ch2 < 1 || ch2 > 3)
                        {
                            System.out.println("The choice has to be from 1 to 3");
                        }
                    } while(ch2 < 1 || ch2 > 3 );
                    
                    userWallChoice(ch2, use);
                }

                else 
                {
                    System.out.println("No friends");
                }
            }
            
            else if(userchoice == 3)
            {
                Menu.choice3();/*emfanizei lista me tous non friends*/
                if(Network.getNonFriends().length > 0)
                {
                    int ch = 0;
                    do
                    {
                        System.out.println("Select a user(1-"+Network.getNonFriends().length+")");
                        ch = makeAChoice();
                        if(ch < 1 || ch > Network.getNonFriends().length)
                        {
                            System.out.println("The number of  non friend users are: "+Network.getNonFriends().length);
                        }
                    } while(ch < 1 || ch > Network.getNonFriends().length);
                    
                    Network.getUserConnected().sendFR(Network.getNonFriends()[ch-1]);/*ekteleitai h sendFR gia na steiloume aithma sto xrhsth pou epilejame apo th lista*/
                }
            }
            else if(userchoice == 4)
            {
                Menu.choice4();
                ArrayList<FriendRequest> requests =  Network.getUserConnected().getFriendRequests();
                
                if(requests.size() > 0)
                {  
                    int ch = 0;
                    do
                    {
                        System.out.println("Select a request(1-"+requests.size()+")");
                        ch = makeAChoice();
                        if(ch < 1 || ch > requests.size())
                        {
                            System.out.println("The number of requests are: "+requests.size());
                        }
                    } while(ch < 1 || ch > requests.size());
                    
                    Scanner input = new Scanner(System.in);
                    String accept;
                    do
                    {
                        System.out.println("Do you want to accept the request "+requests.get(ch-1)+" ?");
                        accept = input.next();
                        
                        if(!accept.equals("yes") && !accept.equals("no"))
                            System.out.println("The answer is either yes or no");
                    } while(!accept.equals("yes") && !accept.equals("no"));

                    if(accept.equalsIgnoreCase("yes"))
                    {
                        Network.getUserConnected().respondeFR(ch-1, true);
                    }
                    else
                    {
                        Network.getUserConnected().respondeFR(ch-1, false);
                    }
                }
            }
            else if(userchoice == 5)
            {
                Menu.choice5(Network.getUserConnected());
            }
            else if(userchoice == 7)
            {
                connectWithApp();//kaleitai h synartisi connectwithapp wste na syndethei enas allos xrhsths dinontas to meil tou
            }
        } while(userchoice != 8);/*oso userchoice diaforo tou 8*/
    }
        
    private static boolean connectWithApp()
    {
        System.out.println("Type user email");
        Scanner into = new Scanner(System.in);
        
        String newEmail = into.nextLine();
        User[] allUsers = Network.getAllUsers();//kaloume ti static methodo getAllUsers tis klasis Network kai 
        //kataxwroume stin topiki metavliti allUsers tous xristes pou einai kataxwrimenoi sto sustima.
        
        for(int i = 0; i < allUsers.length; i++)
        {
            if(allUsers[i].getEmail().equals(newEmail))//me tin etoimi sinartisi equals sigkrinoyme 2 alfarithimitika: Edw sigkrinoume to email
            //pou dwsame gia na sindethoume pou einai sti metavliti newEmail me to email kathe xristi poy einai kataxwrimeno sto systima kai 
            //vrisketai ston pinaka all users.
            {
                Network.setUserConnected(allUsers[i]);
                return true;
            }
            
            if(i == allUsers.length - 1)//ean elegksouem oles tis theseis tou pinaka allUsers kai den vrethei pouthena istotita simainei oti to email pou edwse o xristis einai lathos.
            {
                System.out.println("Please type another email");
                return false;
            }
        }
        
        return true;
    }
    
    private static int makeAChoice()//diavazei apo to pliktrologio enan akeraio kai ton epiostrefei.o akeraios autos antistoixei se epilogh apo ena menu
    {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        
        return choice;
    }
    
    
    private static User userWallChoice(int choice, User user) throws NonFriendException, AlreadyLikedException
    {
        Scanner input = new Scanner(System.in);/*epilegoume apo to ypomenu 1-3*/
        if(choice == 1)
        {
            System.out.println("Message to "+user);
            
            String message = input.nextLine();/*me th nextline diavazw apo to plhktrologio to periexomeno tou mhnymatos*/
            Network.getUserConnected().post(user, message);/*stelnoume me th methodo post ston friend pou vrisketai sth metavliti user to mhnyma*/
        }
        else if(choice == 2)
        {
            
        }
        else/*choice3,edw kanoume like*/
        {
            if(user.getUserWall().getPosts().size() > 0)
            {
                int mes;
                do
                {
                    System.out.println("Select(1-"+user.getUserWall().getPosts().size()+")");
                    mes = makeAChoice();/*epilegoume pou theloume na kanoume like*/

                    if(mes < 1 || mes > user.getUserWall().getPosts().size())
                    {
                        System.out.println("The choice has to be from 1 to "+user.getUserWall().getPosts().size());
                    }
                } while(mes < 1 || mes > user.getUserWall().getPosts().size());
                
                user.like(user.getUserWall().getPosts().get(mes-1));/*kaleitai h methodos like gia to sygkekrimeno mhnyma pou exoume epilejei*/
            }
        }
        
        return user;
    }
}