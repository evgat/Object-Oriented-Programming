#include<iostream>
#include<string>
#include<vector>
#include"Exceptions.h"



using namespace std;

class Message;
class FriendRequest;
class Wall;

class User{
	public:
		User(string , string, string );
		Wall* getUserWall();
		string getEmail();
		string getFirstName();
		string getLastName();
		vector<FriendRequest*> getFriendRequests();
		void setFriendsWall(vector<Wall*> );
		void addFriendsWall(Wall * );
		void sendFR(User *);
		void respondeFR(int , bool );
		void removeFromFriends(User* );
		bool post(User*  ,string );
		void reply(Message*, string reply);
		void like(Message* );
		vector<User*> getFriends();
		friend ostream &operator<<( ostream &, const User * );
		friend bool operator== ( const User &, const User &); 
		~User();
			
	private:
		string email;
		string first;
		string last;
		vector<FriendRequest*> friendRequests;
		Wall *wall;	
		vector<Message*> messagesLiked;
};
