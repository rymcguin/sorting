#include <iostream>
#include <string>
#include <sstream>
using namespace std;
int main(){
    int x = 10;
    cout << x << endl;
    int y = double_me(x);
    cout << x << " " << y << endl;
}

int double_me(int x){
    x = x * 2;
    return x;
}

