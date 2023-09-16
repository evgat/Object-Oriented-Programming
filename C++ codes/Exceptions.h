#ifndef USER_EXCEPTIONS_H
#define USER_EXCEPTIONS_H

#include<iostream>
#include<exception>

using namespace std;

class AlreadyLikedException : public exception{
	public:
		char* what();
	
};

class FriendsException : public exception{
	public:
		char* what();
	
};

class NonFriendException : public exception{
	public:
		char* what();
	
};

class SelfException : public exception{
	public:
		char* what();
	
};


#endif
