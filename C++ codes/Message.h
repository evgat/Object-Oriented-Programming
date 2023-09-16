#ifndef MESSAGE_H
#define MESSAGE_H

#include<iostream>
#include<string>
#include<ctime>

using namespace std;

class User;

class Message{
	
	public: 
		Message(User *, string message);
		void printMessage();
		void setReplyMessage(Message *replyMessage);
		void incrLike();
		friend bool operator== ( const Message &, const Message &); 
		
	private:
		User *userPosted;
		time_t datePosted;
		string message;
		Message *replyMessage;
		int numOfLikes;

};


#endif
