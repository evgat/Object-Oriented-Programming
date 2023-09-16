#ifndef WALL_H
#define WALL_H

#include<iostream>
#include<string>
#include<vector>
#include"Message.h"


class Wall{
	public:
		Wall(User *);
		void post(User* ,  string );
		vector<Message*> getPosts();
		User* getUserName();
		~Wall();
	
	private:
		User *owner;
		vector<Message*> messages;
};

#endif
