import java.util.ArrayList;

public class User
{
    private String email;
    private String first;
    private String last;
    private ArrayList<FriendRequest> friendRequests;
    private Wall wall;
    private ArrayList<Message> messagesLiked;
    
    public User(String email, String first, String last)
    {
        this.email = email;
        this.first = first;
        this.last = last;
        
        friendRequests = new ArrayList<>();
        messagesLiked = new ArrayList<>();
        wall = new Wall(this);
    }
    
   
    public Wall getUserWall()
    {
        return wall;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public String getFirstName()
    {
        return first;
    }
    
    public String getLastName()
    {
        return last;
    }
    
    public ArrayList<FriendRequest> getFriendRequests()
    {
        return friendRequests;
    }
  
    
    public void sendFR(User to) throws SelfException, FriendsException
    {
        FriendRequest request = new FriendRequest(this, to);
        request.areSame();
        request.areAlreadyFriends();
        to.friendRequests.add(request);
    }
    
    public void respondeFR(int r, boolean what)
    {
        FriendRequest request = friendRequests.get(r);
        
        if(what)
        {
            friendRequests.get(r).setStatus("ACCEPTED");
            Network.becomeFriends(this, request.getSender());
        }
        else
        {
            friendRequests.get(r).setStatus("REJECTED");
        }
    }
    
    public void removeFromFriends(User user)
    {
        Network.removeFromFriends(this, user);
    }
    
    public boolean post(User to, String post) throws NonFriendException
    {
        User[] users = Network.getFriends(this);/*h getfriends epistrefei olous tous friends tou xrhsth pou exei kanei login kai tous vazei ston pinaka users*/
        int index = 0;
        
        try
        {
            for(User user : users)/*dhlwnoume mia topikh metavliti user typou User kai thn sysxetizoume me ton pinaka users.se kathe epanalipsi sto user kataxwreitai ena stigmiotypo apo ton pinaka users*/
            {
                if(user.equals(to))
                {
                    user.getUserWall().post(this, post);/*stelnetai to mhnyma apo emena pou exw kanei login(this) ston friend pou exoume epilejei*/
                    return true;
                }
                index++;

                if(index == users.length)
                {
                    throw new NonFriendException("You are not friends with "+to);
                }
            }
            
            return true;
        }
        catch(NonFriendException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        
    }      
    
    public void reply(Message messageToReply, String reply)
    {
       // ReplyMessage repl = new ReplyMessage(new Date(), reply, null, this, 0);
       // messageToReply.setReplyMessage(repl);
    }
    
    public void like(Message message) throws AlreadyLikedException
    {
        try
        {
            for(Message m : messagesLiked)
            {
                if(m.equals(message))/*ean to mynhma pou theloume na kanoume like yparxei hdh sto arraylist me ta hdh likedmessages tote 
                prokaleitai exception kai typwnetai to mhnyma*/
                {
                    throw new AlreadyLikedException("The message has been liked from user");
                }
            }
            
            message.incrLike();
            messagesLiked.add(message);
        }
        catch(AlreadyLikedException e)
        {
            System.out.println(e.getMessage());
        }
    }
   
    public User[] getFriends()
    {
        return Network.getFriends(this);
    }
    
    @Override/*h toString ypervainei thn toString pou klhronomeitai apo thn object*/
    public String toString()
    {
        return first+" "+last+" Email: "+email;
    }
    
    public boolean equals(User other)
    {
        return this.first.equals(other.first) && this.last.equals(other.last) && this.email.equals(other.email);
    }
}