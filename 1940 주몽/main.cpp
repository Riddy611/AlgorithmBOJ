#include <iostream>
#include <algorithm>
using namespace std;

int main () {
    int n, m;
    cin >> n >> m;
    int arr[15001];
    for (int i=0; i<n; i++) {
        cin>>arr[i];
    }
    sort(arr, arr+n);
    int count=0;
    int start=0, end=n-1;
    while(start<end) {
        if ((arr[start]+arr[end])==m) {
            count++;
            start++, end--;
        } else if (arr[start]+arr[end]<m) {
            start++;
        } else if (arr[start]+arr[end]>m) end--;
    }
    
    cout <<count;
    return 0;
}