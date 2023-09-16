#include"Exceptions.h"

char* AlreadyLikedException::what(){
	return "You have liked this message";
}

char* FriendsException::what(){
	return "You are friends with this user";
}

char* NonFriendException::what(){
	return "You are not friends with this user";
}

char* SelfException::what(){
	return "Trying to send request to self";
}
