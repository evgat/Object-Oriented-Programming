import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Network 
{
    private static User userConnected;
    private static Map<User,ArrayList<User>> users = new HashMap<>();

    public static void setMap(Map<User, ArrayList<User>> users)
    //h klash Map einai enas typos dedomenwn pou epitrepei mia antistoixish metajy enos kleidiou kai mias timhs
    //o typos Map de mporei na periexei diplotypa kleidia kai to kathe kleidi mporei na periexei to poly mia timh.
    //dhlwnontas stigmiotypo sthn klash hashmap mporoume na exoume kleidia xwris timh.To kleidi einain user kai to value einai ena arraylist me tous filous tou xrhsth autou
    {
        Network.users = users;
    }
    
    public static void addUser(User user)
    {
        users.put(user, new ArrayList<>());//me thn etoimh synartisi put eisagoume to xrhsth auto ws mia nea eggrafh sto map users.
        //to arraylistme tous filous tou user autou dhnmiourgeitai kai arxika einai keno
    }
    
    
    public static void becomeFriends(User user, User other)
    {
        users.get(user).add(other);//px an exoume thn klhsh becomefriends(user1,user2) tote tha ginei to ejhs: phgainoume sth thesi user1 tou map users kai me th synartisi add prosthetoume ton user2 sto arraylist me tous filous tou user1  
        users.get(other).add(user);//auto ginetai kai pros thn antitheti kateuthinsi wste o user1 na prosthethei sto arraylist me tous filous tou user2
    }
    
    public static User[] getFriends(User user)/*h synartisi auth lamvanei ws orisma ena user kai epistrefei ena statiko pinaka me olous tous filous tou*/
    {
        return users.get(user).toArray(new User[users.get(user).size()]);/*h users.get(user) epistrefei ena arraylist me tous filous tou user. me to size()upologizoume to megethos tou arraylist px 3,
        sth synxeia me to new User[px 3] desmeuoume mnhmh gia ena statiko pinaka me stigmiotypa typou user.sth synxeia me th synartisi toarray pairnoume to arraylist pou epistrefei h ejwterikh 
        users.get(user) kai to kataxwroume sto neo pinaka,sto telos epistrefoume to neo pinaka me tous friends*/
    }
    
    public static User[] getAllUsers()//epistrefei ena pinaka pou periexei tous users pou exoume eisagei mesa sto map
    {
        Set<User> keys = users.keySet();//o typos set einai mia syllogh antikeimenwn sthn opoia den epitrepontai diplotypes times.kalwntas th synartisi keyset dhmiourgoume th lista auth kai kataxwroume sth lista auth ola ta kleidia tou map users.ta kleidia auta einai ta user1,user2...user8 twn xrhstwn 
        User[] allUsers = keys.toArray(new User[keys.size()]);//h synartisi keys toArray metatrepei to set se pinaka kai to megethos tou einai idio me to megethos tou synolou keys
        return allUsers;
    }
    
    
    public static boolean areFriends(User user, User other)
    {
        if(user.equals(other))
        {
            return false;
        }
        
        User[] allFriends = getFriends(other);
        
        for(User u : allFriends)
        {
            if(user.equals(u))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public static ArrayList<User> getMutualFriends(User user1, User user2)
    {
        ArrayList<User> friendsU1 = users.get(user1);
        friendsU1.retainAll(users.get(user2));
        return friendsU1;
    }
    
    public static void removeFromFriends(User user1, User user2)
    {
        users.get(user1).remove(user2);
        users.get(user2).remove(user1);
    }
    
    public static void setUserConnected(User user)
    {
        userConnected = user;//sto melos userConnected (pou deixnei to xristi pou exei kanei login) kataxwroume to xristi pou edwse swsto email.
    }
    
    public static User getUserConnected()
    {
        return userConnected;
    }
    
    public static User[] getNonFriends()
    {
        User[] all = Network.getAllUsers();
        User[] friends = Network.getFriends(Network.getUserConnected());
        ArrayList<User> nonFriends = new ArrayList<>();
        
        for(int i = 0; i < all.length; i++)
        {
            boolean found = false;
            
            for(int j = 0; j < friends.length; j++)
            {
                if((all[i].equals(friends[j])) && !all[i].equals(userConnected))
                {
                    found = true;
                }
            }
            
            if(!found)
            {
                nonFriends.add(all[i]);
            }
        }
        
        return nonFriends.toArray(new User[nonFriends.size()]);
    }
}