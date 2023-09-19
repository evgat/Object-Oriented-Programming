# Object-Oriented-Programming - Social Network System using Java and C++
CEID PROJECT 2019

In the context of this project, a simplified social network system was implemented that supports user registration, sending messages and replies to messages, likes, sending friendship requests, and accepting/rejecting them and could include the classes described below. 

1. Class User: Represents a user of the social network and is characterized by their name and email. It also maintains a list of friend requests submitted or accepted, as well as the user's wall, in a 1-1 relationship.
2. Class FriendRequest: represents a friend request between two users. It has methods to display the message information (users, direction), the timestamp, and its status (accepted/rejected/pending).
3. Class Wall: represents a user's wall where posts are published and replies and likes are displayed. Each wall has a list of the messages posted on it. A user is only allowed to post on their own wall or their friends' walls. It therefore has methods for checking whether each user who wants to post has the right to do so.
4. Class Message: represents a message and contains as properties the timestamp of the message (Date), the text, the user who created it, and the next response written under this message. It also includes information on the number of likes the message has received. Each message when printed (toString) should also contain all replies posted below it (i.e. all replies that refer to it).
5. Class ReplyMessage: Each reply is also a Message with its own timestamp etc.
6. Class Network: represents the social network that is formed. The class can have only one instance (singleton). It stores the users (thus also the walls and the posts). Represents friendship relationships in the network by maintaining a graph (e.g. Map mapping users to a list of their friends).
7. Class Menu: represents the application's menu and includes methods for printing options, handling user input, and menu navigation.
8. Exception Classes: appropriate exception classes should be implemented and handled in case of illegal actions. For example, trying to add a friend that already exists raises an exception, trying to post on a user's wall that is not a friend raises an exception, sending a friend request to an existing friend, adding an existing user, entering an invalid option in the menu, etc.

# Application Functionality:

Configure a suitable command line menu where the username will initially be requested. The system will identify the user and then show them the following menu of options:

1. See your wall (View user's wall): the user's wall will be presented with all their own posts, their friends' posts, and any replies in a discussion format (with indentation), in chronological order from the oldest to the most recent. For each post, the total number of likes it has collected should also be displayed (without the information of the user who did it).
   
2. See friend's wall: As above, but for a friend's wall. It is selected from a numbered list of friends that the option displays.

   - Post a message (Send a message to the wall): Once a wall is selected, the system asks the user to enter the text of the message to be sent to the wall.

   - Reply to a message: a numbered list of messages on the user's wall is displayed and the user selects the corresponding message number and then enters the reply text

   - Like: A list of all the messages (numbered) on the user's wall is displayed and the user selects the one he/she wants to like.

3. Send friend request: a numbered list of users who are not his friends is displayed and he/she is asked to select a user (by entering the corresponding number).
4. Accept/Reject friend request: a numbered list of users who have sent a friend request to the current user is displayed, and the user selects the number of the request they want to accept/reject.
5. See my friends: the system displays all the user's friends.
6. Back. Goes back one level up in the menu each time.
7. Logging out of a user and asking for another user to log in.
8. Exit program.

The implementation was done in both Java and C++.
