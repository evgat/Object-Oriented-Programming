import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FriendRequest
{
    private User from;
    private User to;
    private Date date;
    private String status;
    
    public FriendRequest(User from, User to)
    {
        this.from = from;
        this.to = to;
        
        date = new Date();
        status = "PENDING";
    }
    
    
    public void areSame() throws SelfException
    {
        try
        {
            if(from.equals(to))
            {
                throw new SelfException("Trying to responde to request from self");
            }
        }
        catch(SelfException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void areAlreadyFriends() throws FriendsException
    {
        try
        {
            if(Network.areFriends(from, to))
            {
                throw new FriendsException("Already friends");
            }
        }
        catch(FriendsException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public User getSender()
    {
        return from;
    }
    
    public void printRequest()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("There is a friend request from "+from+" to "+to+" with status "+status+".  Date: "+dateFormat.format(date));
    }
}