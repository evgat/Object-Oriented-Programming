#ifndef NETWORK_H
#define NETWORK_H

#include<iostream>
#include<map>
#include<vector>
#include<string>
#include"FriendRequest.h"
#include"User.h"

using namespace std;

class Network{
	public:
		static void setMap(map<User*, vector<User*> >);
		static void addUser(User* );
		static void becomeFriends(User*, User* );
		static vector<User*> getFriends(User* );
		static vector<User*> getAllUsers();
		static bool areFriends(User *user, User *other);
		static void setUserConnected(User *user);
		static User* getUserConnected();
		static vector<User*> getNonFriends();
		
		
	private:
		static User *userConnected;
		static map<User*, vector<User*> > users;
};

#endif
