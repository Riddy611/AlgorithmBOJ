#include <iostream>
#include <cmath>
#include <vector>
using namespace std;

int main () {
    // int n;
    // cin >> n;
   // vector<int> avail;
    // int count=0;
    // double t=0;
    double temp;
    cout<<pow(5,2)<<endl;
    for (int i=1; i<10; i++) {
        temp=pow(i,2);
        cout<<"now i is : "<<i<<"   and the pow is : "<<temp<<endl;
    }
    // for (int i=1; i<10; i++) {
    //     p=pow(i,2);
    //     cout<<p<<endl;
    //     if ((p-n)>0) {
    //         t=sqrt(p-n);
    //         if ((t-(int)t)==0) {
    //             cout<<"now num is : "<<i<<"  and p is : "<<p<<"   and t is : "<<t<<endl;
    //             avail.push_back(i);
    //             count++;
    //         }
    //     }
        
    // }

    // for (int i=0; i<count; i++) {
    //     cout<<avail[i]<<endl;
    // }
    return 0;
}