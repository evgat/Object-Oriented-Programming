import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message
{
    private User userPosted;
    private Date datePosted;
    private String message;
    private Message replyMessage;
    private int numOfLikes;
    
    public Message(User userPosted, String message)
    {
        datePosted = new Date();
        this.message = message;
        this.replyMessage = null;
        this.userPosted = userPosted;
        this.numOfLikes = 0;
    }
    
    public void printMessage()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");//dimiourgoume stigmiotypo dateFormat typou DateFormat kai kaloume to dimiourgo tis klasis SimpleDateFormat(paragwmeni klasi) gia na kathorisoume ti morfi pou tha exei to TimeStamp tou minimatos.
        System.out.println("From "+userPosted.getEmail()+" | Message "+message+ " at "+dateFormat.format(datePosted) +" | Likes "+numOfLikes);//emfanizoume to email tou xristi, to periexomeno tou minimatos pou vrisketai sto melos message.to melos datePosted me ti morfopoioisi pou exoume kathorisei kai to plithos twn likes tou minimatos pou vrisketai sto melo numOfLikes.
        
        Message reply = this.replyMessage;
        
        while(reply != null)
        {
            System.out.println("\tFrom "+reply.userPosted.getEmail()+" | Reply "+reply.message+" at "+dateFormat.format(datePosted)+" | Likes "+reply.numOfLikes);
            reply = replyMessage.replyMessage; 
        }
    }
    
    public void setReplyMessage(Message replyMessage)
    {
        this.replyMessage = replyMessage;
    }
    
    public void incrLike()
    {
        numOfLikes += 1;
    }
    
    public boolean equals(Message message)
    {
        return message.datePosted.compareTo(this.datePosted) == 0 && message.userPosted.equals(this.userPosted);
    }     
}