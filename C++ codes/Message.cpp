#include"Message.h"
#include"User.h"

Message::Message(User *userPosted, string message){
    datePosted = time(0);
    this->message = message;
    this->replyMessage = NULL;
    this->userPosted = userPosted;
    this->numOfLikes = 0;
}

     
void Message::printMessage(){
    cout<<"From "<<userPosted->getEmail()<<" | Message "<<message<< " at "<<time(0) <<" | Likes "<<numOfLikes<<endl;
    
    Message *reply = this->replyMessage;
    
    while(reply != NULL){
       
        cout<<"\tFrom "<<reply->userPosted->getEmail()<<" | Reply "<<reply->message<<" at "<<time(0)<<" | Likes "<<reply->numOfLikes;
        
        reply = replyMessage->replyMessage; 
    }
}
    
void Message::setReplyMessage(Message *replyMessage){
    this->replyMessage = replyMessage;
}
    
void Message::incrLike(){
    numOfLikes += 1;
}

bool operator== ( const Message &m1, const Message &m2){
    return m1.datePosted == m2.datePosted && m1.userPosted == m2.userPosted;
}
