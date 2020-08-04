#include <iostream>
#include <algorithm>

using namespace std;


int calc(int arr[], int input[], int cur) {
    int max=0;
    for (int i=1; i<cur; i++) {
        if (input[i-1]>input[cur-1]) {
            if (arr[i]>max) {max=arr[i];}
        }
    }
    return max;
}

int main() {
    int n;
    int arr[1001]={0,};
    cin >> n ;
    int input[n];
    for (int i=0; i<n; i++) {
        cin >> input[i];
    }
    int max=0;
    for (int i=1; i<=n; i++) {
        arr[i]=1+calc(arr, input, i);
        if (arr[i]>max) {max=arr[i];}
    }
    // if (max==1) {
    //     max=0;
    // }
    cout<<max;
    return 0;
}
