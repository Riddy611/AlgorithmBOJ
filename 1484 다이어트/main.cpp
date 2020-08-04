#include <iostream>
#include <cmath>
//#include <vector>
using namespace std;

int main () {
    int n;
    cin >> n;
   // vector<int> avail;
    int count=0;
    double t=0;
    double p;
    bool check=false;
    // for (int i=1; i<10; i++) {
    //     temp=pow(i,2);
    //     cout<<temp<<endl;
    // }
    for (int i=(int)sqrt(n)+1; 1ll*i*i-1ll*(i-1)*(i-1)<=n; i++) {
        p=pow(i,2);
        //cout<<p<<endl;
        if ((p-n)>0) {
            t=sqrt(p-n);
            if ((t-(int)t)==0) {
                //cout<<"now num is : "<<i<<"  and p is : "<<p<<"   and t is : "<<t<<endl;
                //avail.push_back(i);
                //count++;
                check=true;
                cout<<i<<endl;
            }
        }
    }

    if(!check) {cout<<-1;}
    return 0;
}