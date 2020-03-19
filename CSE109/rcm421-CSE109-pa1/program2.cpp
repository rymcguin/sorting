/*Ryan McGuiness 
Prof Montella
CSE-109
July 15,2019
rcm421@lehigh.edu
*/
#include <iostream>
#include <string>

int main()
{
    string userString;
    cin>>userString;
    int i;
    for(i=0; i< userString.size(); i++){
        cout<<userString.at(i)<<"*"<<endl;
    }
}