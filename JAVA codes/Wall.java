import java.util.ArrayList;

public class Wall 
{
    private User owner;//o xrhsths pou exei to wall auto 
    private ArrayList<Message> messages;//to melos messages einai typou arraylist<message>kai periexei ola ta mynhmata pou einai dhmosieumena sto wall tou
    
    public Wall(User owner)
    {
        this.owner = owner;
        messages = new ArrayList<>();
    }
    
    public void post(User from, String message)
    {
        Message post = new Message(from, message);
        messages.add(post);
    }
   
    public ArrayList<Message> getPosts()//epistrefei to arraylist me ola ta messages pou vriskontai sto wall autou tou xrhsth
    {
        return messages;
    }
    
    public User getUserName()
    {
        return owner;
    }
}