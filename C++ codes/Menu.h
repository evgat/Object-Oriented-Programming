#ifndef MENU_H
#define MENU_H

#include<iostream>
using namespace std;

class FriendRequest;
class User;


class Menu{
	public:
		static void main();
		static void choice1();
	    static void userFriends();
	    static void choice2(User *user);
		static void choice3();
		static void choice4();
		static void choice5(User *user);
};

#endif

