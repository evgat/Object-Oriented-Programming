#ifndef FRIENDREQUEST_H
#define FRIENDREQUEST_H

#include<iostream>
#include<ctime>
#include"Exceptions.h"
#include"Network.h"


using namespace std;

class User;

class FriendRequest{
	public:
		FriendRequest(User*, User*, time_t);
		bool areSame();
		bool areAlreadyFriends();
		void setStatus(string status);
		string getStatus();
		User* getSender();
		void printRequest();
		
	private:
		User *from;
		User *to;
		time_t date;
		string status;
};


#endif
