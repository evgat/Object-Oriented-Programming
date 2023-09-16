import java.util.ArrayList;

public class Menu 
{
    public static void main()
    {
        System.out.println
                ("***************************************\n"+
                "**********     Menu     ****************\n"+
                "****************************************\n"+
                "*******  1. See your wall  *************\n"+
                "*******  2. See friends wall ***********\n"+
                "*******  3. Send friend request ********\n"+
                "*******  4. Accept/Reject friend request\n"+  
                "*******  5. See my friends *************\n"+
                "*******  6. Back ***********************\n"+  
                "*******  7. Log out   ******************\n"+  
                "*******  8. Exit ***********************\n"+  
                "***************************************\n");
    }  
    
    public static void choice1()
    {
        System.out.println(Network.getUserConnected().getUserWall().getUserName());//epistrefei to stigmiotypo tou xristi( onoma eponymo email pou exei kanei login sto sistima kai exei Wall.
        ArrayList<Message> messages =  Network.getUserConnected().getUserWall().getPosts();//sto topiko Array List messages kataxwrountai apo tin getPosts ola ta minimata pou vriskontai sto Wall autou tou xristi.
        
        if( messages.size() > 0)//ean yparxoun minimata sto Array List messages
        {
            for(int i = 0; i < messages.size(); i++)//ekteloume epanalipsi gia to kathe message 
            {
                int index = i + 1;
                messages.get(i).printMessage();//lamvanoume to message sti thesi i tou Array List messages kai kaloume ti methodo printMessage().
            }
        }
        else
        {
            System.out.println("No posts");
        }
    }
    
    public static void userFriends()//h synartisi auth typwnei sthn othoni to arraylist me tous friends tou user pou exei kanei login
    {
        for(int i = 0; i < Network.getUserConnected().getFriends().length; i++)
        {
            int index = i + 1;
            System.out.println(index+". "+Network.getUserConnected().getFriends()[i]);
        }
    }
    
    public static void choice2(User user)/*h parametros user periexei to filo pou exoume epilejei*/
    {
        ArrayList<Message> messages =  user.getUserWall().getPosts();/*sthn topikh metavliti messages kataxwrountai ola ta mhnymaata pou vriskontai sto wall autou tou friend user*/ 
        
        if( messages.size() > 0)
        {
            for(int i = 0; i < messages.size(); i++)
            {
                int index = i + 1;
                messages.get(i).printMessage();
            }
        }
        else
        {
            System.out.println("No posts");
        }

        System.out.println(""
                +"****************************\n"
                +"**** 1. Post a message******\n"
                +"**** 2. Reply to a message**\n"
                +"**** 3. Like\n**************\n"
                +"****************************\n");
    }
    
    public static void choice3()
    {
        if(Network.getNonFriends().length > 0)
        {
            for(int i = 0; i < Network.getNonFriends().length; i++)
            {
                int index = i + 1;
                System.out.println(index+". "+Network.getNonFriends()[i]);
            }
        }
        else
        {
            System.out.println("All users are friends");
        }
    }
    
    public static void choice4()
    {
        ArrayList<FriendRequest> requests =  Network.getUserConnected().getFriendRequests();
        
        if(requests.size() > 0)
        {
            for(int i = 0; i < Network.getUserConnected().getFriendRequests().size(); i++)
            {
                int index = i + 1;
                
                if(requests.get(i).getStatus().equalsIgnoreCase("PENDING"))/*ejetazetai h katastash tou kathe aithmatos filias me th lejh pending,anejjarthtou grafhs ths lejhs(kefalaia-peza)
                dhladh an ekremmoun ta aithmata*/
                {
                    System.out.print(index+": ");
                    requests.get(i).printRequest();
                }
            }
            
            System.out.println();
        }
        else
        {
            System.out.println("No friend requests");
        }
    }
    
    public static void choice5(User user)
    {
        for(int i = 0; i < user.getFriends().length; i++)
        {
            int index = i + 1;
            System.out.println(index+". "+user.getFriends()[i]);
        }
        
        System.out.println();
    }
}