#include <iostream>
#include <algorithm>

using namespace std;

long arr[91];
int main() {
    long n;
    int i, t;
    cin >> n ;

    for (i=1; i<=n; i++) {
        t=i-2;
        if (i==1 || i==2) {arr[i]=1;}
        else {
            while(t>0) {
                arr[i]+=arr[t];
                t--;
            }
            arr[i]+=1;
        }
    }
   
    cout<<arr[n];
    return 0;
}
