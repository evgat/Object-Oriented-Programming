#include"FriendRequest.h"

FriendRequest::FriendRequest(User *from, User *to, time_t time){
    this->from = from;
    this->to = to;
    date = time;
    status = "PENDING";
}


bool FriendRequest::areSame() {
	try{
		if(from == to){
        	throw SelfException();
    	}
    	return true;
	}
	catch(SelfException& ex){
		cout<<ex.what()<<endl;
	}

}

bool FriendRequest::areAlreadyFriends(){
	try{
		if(Network::areFriends(from, to)){
        	throw FriendsException();
    	}
    	return true;
	}
	catch(FriendsException& ex){
		cout<<ex.what()<<endl;
		return false;
	}
}

void FriendRequest::setStatus(string status){
    this->status = status;
}

string FriendRequest::getStatus(){
    return status;
}

User* FriendRequest::getSender(){
    return from;
}

void FriendRequest::printRequest(){
    cout<<"There is a friend request from "<<from<<" to "<<to<<" with status "<<status<<".  Date: "<<date<<endl;
}
