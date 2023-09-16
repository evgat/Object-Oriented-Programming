#include"Menu.h"
#include<vector>
#include"Network.h"
#include"Wall.h"
#include"FriendRequest.h"


void Menu::main(){
    cout<<"***************************************\n"<<
            "**********     Menu     ****************\n"<<
            "****************************************\n"<<
            "*******  1. See your wall  *************\n"<<
            "*******  2. See friends wall ***********\n"<<
            "*******  3. Send friend request ********\n"<<
            "*******  4. Accept/Reject friend request\n"<< 
            "*******  5. See my friends *************\n"<<
            "*******  6. Back ***********************\n"<<  
            "*******  7. Log out   ******************\n"<<  
            "*******  8. Exit ***********************\n"<<  
            "***************************************\n"<<endl;
}  

void Menu::choice1(){
    cout<<Network::getUserConnected()->getUserWall()->getUserName()<<endl;
    vector<Message*> messages =  Network::getUserConnected()->getUserWall()->getPosts();
    if( messages.size() > 0){
        for(int i = 0; i < messages.size(); i++){
            int index = i + 1;
            messages[i]->printMessage();
        }
    }
    else{
        cout<<"No posts"<<endl;
    }
}

void Menu::userFriends(){
    for(int i = 0; i < Network::getUserConnected()->getFriends().size(); i++){
        int index = i + 1;
        cout<<index<<". "<<Network::getUserConnected()->getFriends()[i]<<endl;
    }
}

void Menu::choice2(User *user){
    vector<Message*> messages =  user->getUserWall()->getPosts();
    if( messages.size() > 0){
        for(int i = 0; i < messages.size(); i++){
            int index = i + 1;
            messages[i]->printMessage();
        }
    }
    else{
        cout<<"No posts"<<endl;
    }

            cout<<"****************************\n"
            <<"**** 1. Post a message******\n"
            <<"**** 2. Reply to a message**\n"
            <<"**** 3. Like\n**************\n"
            <<"****************************\n";
}

void Menu::choice3(){
    if(Network::getNonFriends().size() > 0){
        for(int i = 0; i < Network::getNonFriends().size(); i++){
            int index = i + 1;
            cout<<index<<". "<<Network::getNonFriends()[i]<<endl;
        }
    }
    else{
        cout<<"All users are friends"<<endl;
    }
}

void Menu::choice4(){
    vector<FriendRequest*> requests =  Network::getUserConnected()->getFriendRequests();
    if(requests.size() > 0){
        for(int i = 0; i < Network::getUserConnected()->getFriendRequests().size(); i++){
            int index = i + 1;
            if(requests[i]->getStatus().compare("PENDING") == 0){
                cout<<index<<". "<<requests[i]<<endl;
                cout<<index<<": ";
                requests[i]->printRequest();
            }
        }
        cout<<endl;
    }
    else{
        cout<<"No friend requests"<<endl;
    }

}

void Menu::choice5(User *user){
    for(int i = 0; i < user->getFriends().size(); i++){
        int index = i + 1;
        cout<<index<<". "<<user->getFriends()[i]<<endl;
    }
    cout<<endl;
}
