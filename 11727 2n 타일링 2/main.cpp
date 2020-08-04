#include <iostream>
#include <algorithm>

using namespace std;

long arr[1001];
int main() {
    int n,t ;
    cin >> n ;
    arr[0]=1;
    arr[1]=1;
    arr[2]=3;
    for (int i=3; i<=n; i++) {
        arr[i]=arr[i-1]+2*arr[i-2];
    }

    cout<<arr[n]%10007;
    return 0;
}
