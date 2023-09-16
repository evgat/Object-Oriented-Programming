#include<iterator> 
#include <algorithm>
#include"Network.h"

using namespace std;

map<User*,vector<User*> > Network::users;
User* Network::userConnected;

void Network::setMap(map<User*, vector<User*> > users){
    Network::users = users;
}

void Network::addUser(User *user){
	vector<User*> f;
	users[user] = f;
}


void Network::becomeFriends(User *user, User *other){
    users[user].push_back(other);
    users[other].push_back(user);
}

vector<User*> Network::getFriends(User *user){
    return users[user];
}

vector<User*> Network::getAllUsers(){
   	vector<User*> tmp;
	for(map<User*,vector<User* > >::iterator it = users.begin(); it != users.end(); ++it) {
  		tmp.push_back(it->first);
	}	
	return tmp;
}


bool Network::areFriends(User *user, User *other){
    if(user == other ){
        return false;
    }
    vector<User*> allFriends = getFriends(other);
    for(int i = 0; i < allFriends.size(); i++){
        if(user == allFriends[i]){
            return true;
        }
    }
    return false;
}

void Network::setUserConnected(User *user){
    userConnected = user;
}

User* Network::getUserConnected(){
    return userConnected;
}

vector<User*> Network::getNonFriends(){
    vector<User*> all = Network::getAllUsers();
    vector<User*> friends = Network::getFriends(Network::getUserConnected());
    vector<User*> nonFriends;
    for(int i = 0; i < all.size(); i++){
        bool found = false;
        for(int j = 0; j < friends.size(); j++){
            if(all[i] == friends[j]){
                found = true;
            }
        }
        if(!found){
            nonFriends.push_back(all[i]);
        }
    }
    return nonFriends;
}



