#include<ctime>
#include"Wall.h"

Wall::Wall(User *owner){
	this->owner = owner;
}

void Wall::post(User *from, string message){
    Message *post = new Message(from, message);
    messages.push_back(post);
}

vector<Message*> Wall::getPosts(){
	return messages;
}

User* Wall::getUserName(){
	return owner;
}

