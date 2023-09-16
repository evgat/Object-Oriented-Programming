#include <iostream>
#include <cstdlib>
#include <ctime>
#include <sstream>
#include"Network.h"
#include"Menu.h"
#include"Wall.h"

using namespace std;


bool connectWithApp(){
    cout<<"Type user email"<<endl;
    string newEmail;
    cin.sync(); 
    getline(cin, newEmail);
    vector<User*> allUsers = Network::getAllUsers();
    for(int i = 0; i < allUsers.size(); i++){
        if(allUsers[i]->getEmail().compare(newEmail) == 0){
            Network::setUserConnected(allUsers[i]);
            return true;
        }
        if(i == allUsers.size() - 1){
            cout<<"Please type another email"<<endl;
            return false;
        }
    }
    return true;
}

int makeAChoice(){
    int choice;
    cin>>choice;
    return choice;
}

User *userWallChoice(int choice, User *user) {
    if(choice == 1){
        cout<<"Message to "<<user<<endl;
        cin.sync(); 
        string message;
        getline(cin,message);
        Network::getUserConnected()->post(user, message);

    }
    else if(choice == 2){
        
    }
    else{
        if(user->getUserWall()->getPosts().size() > 0){
            int mes;
            do{
                cout<<"Select(1-"<<user->getUserWall()->getPosts().size()<<")"<<endl;
                mes = makeAChoice();

                if(mes < 1 || mes > user->getUserWall()->getPosts().size()){
                    cout<<"The choice has to be from 1 to "<<user->getUserWall()->getPosts().size()<<endl;
                }
            }while(mes < 1 || mes > user->getUserWall()->getPosts().size());
            user->like(user->getUserWall()->getPosts()[mes-1]);
            
        }
        

    }
    return user;
}


int main(int argc, char** argv) {
	User *user1 = new User("mail1", "first1","last1");
    Network::addUser(user1);
    
    User *user2 = new User("mail2", "first2","last2");
    Network::addUser(user2);
    
    User *user3 = new User("mail3", "first3","last3");
    Network::addUser(user3);
    User *user4 = new User("mail4", "first4","last4");
    Network::addUser(user4);
    User *user5 = new User("mail5", "first5","last5");
    Network::addUser(user5);
    User *user6 = new User("mail6", "first6","last6");
    Network::addUser(user6);
    
    User *user7 = new User("mail7", "first7","last7");
    Network::addUser(user7);
    
    User *user8 = new User("mail8", "first8","last8");
    Network::addUser(user8);

	
	Network::becomeFriends(user1, user2);
    
    bool connected;
    do{
        connected = connectWithApp();
    }while(!connected);
    int userchoice;
    do{
        Menu::main();
        cout<<endl;
        
        do{
            cout<<"Select(1-8)"<<endl;
            userchoice = makeAChoice();
            if(userchoice < 1 || userchoice > 8){
                cout<<"The choice has to be from 1 to 8"<<endl;
            }
        }while(userchoice < 1 || userchoice > 8);


        if(userchoice == 1){
            Menu::choice1();
        }
        else if(userchoice == 2){
            Menu::userFriends();
            cout<<endl;
            int ch2;
            if(Network::getFriends(Network::getUserConnected()).size() > 0){
                do{
                    cout<<"Select(1-"<<Network::getFriends(Network::getUserConnected()).size()<<")"<<endl;
                    ch2 = makeAChoice();
                    if(ch2 < 1 || ch2 > Network::getFriends(Network::getUserConnected()).size()){
                        cout<<"The choice has to be from 1 to "<<Network::getFriends(Network::getUserConnected()).size()<<endl;
                    }
                }while(ch2 < 1 || ch2 > Network::getFriends(Network::getUserConnected()).size());
                User *use = Network::getFriends(Network::getUserConnected())[ch2 - 1];
                Menu::choice2(use);
                do{
                    cout<<"Select(1-3)"<<endl;
                    ch2 = makeAChoice(); 
                    if(ch2 < 1 || ch2 > 3){
                        cout<<"The choice has to be from 1 to 3"<<endl;
                    }
                }while(ch2 < 1 || ch2 > 3 );
                userWallChoice(ch2, use);
            }

            else{
                cout<<"No friends"<<endl;
            }
        }
        else if(userchoice == 3){
            Menu::choice3();
            if(Network::getNonFriends().size() > 0){
                
                int ch = 0;
                do{
                    cout<<"Select a user(1-"<<Network::getNonFriends().size()<<")"<<endl;
                    ch = makeAChoice();
                    if(ch < 1 || ch > Network::getNonFriends().size()){
                        cout<<"The number of  non friend users are: "<<Network::getNonFriends().size();
                    }
                }while(ch < 1 || ch > Network::getNonFriends().size());
                Network::getUserConnected()->sendFR(Network::getNonFriends()[ch-1]);
            }
        }
        else if(userchoice == 4){
            Menu::choice4();
            vector<FriendRequest*> requests =  Network::getUserConnected()->getFriendRequests();
            if(requests.size() > 0){  
                int ch = 0;
                do{
                    cout<<"Select a request(1-"<<requests.size()<<")"<<endl;
                    ch = makeAChoice();
                    if(ch < 1 || ch > requests.size()){
                        cout<<"The number of requests are: "<<requests.size()<<endl;
                    }
                }while(ch < 1 || ch > requests.size());
                string accept;
                do{
                    cout<<"Do you want to accept the request "<<requests[ch-1]<<" ?"<<endl;
                    getline(cin, accept);
                    if(accept.compare("yes") != 0 && accept.compare("no") != 0)
                        cout<<"The answer is either yes or no"<<endl;
                }while(accept.compare("yes") != 0 && accept.compare("no") != 0);

                if(accept.compare("yes") == 0){
                    Network::getUserConnected()->respondeFR(ch-1, true);
                }
                else{
                    Network::getUserConnected()->respondeFR(ch-1, false);
                }
               
            }
        }
        else if(userchoice == 5){
            Menu::choice5(Network::getUserConnected());
        }
        else if(userchoice == 7){
            connectWithApp();
        }
    }while(userchoice != 8);
	
	return 0;
}
