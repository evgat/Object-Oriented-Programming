#include<ctime>
#include<exception>
#include<iterator>

#include"Wall.h"
#include"FriendRequest.h"

User::User(string email, string first, string last){
    this->email = email;
    this->first = first;
    this->last = last;
    wall = new Wall(this);
}


Wall* User::getUserWall(){
    return wall;
}

string User::getEmail(){
    return email;
}

string User::getFirstName(){
    return first;
}

string User::getLastName(){
    return last;
}

vector<FriendRequest*> User::getFriendRequests(){
    return friendRequests;
}


void User::sendFR(User *to){
    FriendRequest *request = new FriendRequest(this, to, time(0));
    if(!request->areSame()  && !request->areAlreadyFriends()){
    	to->friendRequests.push_back(request);
	}
    
    

}

void User::respondeFR(int r, bool what){
    FriendRequest *request = friendRequests[r];
    if(what){
        friendRequests[r]->setStatus("ACCEPTED");
        Network::becomeFriends(this, request->getSender());
    }
    else{
        friendRequests[r]->setStatus("REJECTED");
     }
}

bool User::post(User *to, string post){
    vector<User*> users = Network::getFriends(this);
    int index = 0;
    try{
    	for(int i = 0; i < users.size(); i++){
	        if(users[i] == to){
	            users[i]->getUserWall()->post(this, post);
	            return true;
	        }
        	index++;
	        if(index == users.size()){
	            throw NonFriendException();
	        }
	    }
    	return true;
	}
	catch(NonFriendException& ex){
		cout<<ex.what()<<endl;
	}

}      


void User::like(Message *message){
	try{
		for(int i = 0; i < messagesLiked.size(); i++){
	        if(messagesLiked[i] == message){
	            throw AlreadyLikedException();
	        }
    	}
    	message->incrLike();
    	messagesLiked.push_back(message);
	}
	catch(AlreadyLikedException& ex){
		cout<<ex.what()<<endl;
	}
    
}


vector<User*> User::getFriends(){
    return Network::getFriends(this);
}

bool operator== ( const User &U1, const User &U2){
    return U1.first.compare(U2.first) == 0 && U1.last.compare(U2.last) == 0 && U1.email.compare(U2.email);
}

ostream &operator<<( ostream &Str, const User *U ){
	Str<<U->first<<" "<<U->last<<" "<<U->email;
	return Str;
}



