#include <iostream>
#include <algorithm>
using namespace std;

int main () {
    int n, m;
    cin >> n >> m;
    int arr[100001];
    int sum[100000];
    for (int i=0; i<n; i++) {
        cin>>arr[i];
    }
    int temp=0;
    for (int i=0; i<m; i++) {
        temp+=arr[i];
    }
    int max=temp;
    sum[0]=temp;
    
    int left=0, right=m;
    while(right<n) {
        temp=temp-arr[left]+arr[right];
        sum[left+1]=temp;
        left++;
        right++;
        if (temp>max) max=temp;
    }
    cout<<max;
    return 0;
}