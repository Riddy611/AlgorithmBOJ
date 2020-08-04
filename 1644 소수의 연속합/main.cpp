#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

bool check(int a) {
    double sq=sqrt(a);
    int i=2;
    while(i<=sq) {
        if (a%i==0) {
            return false;
            //break;
        } else {
            i++;
        }
    }
    return true;
}

int main (){
    long long n, count=0,sum=0;
    cin >>n;
    vector<int> arr;
    bool avail=false;
    for (int i=n; i>1; i--) {
        if(check(i)) {
            arr.push_back(i);
        }
    }
    if (arr.empty()) {
        cout<<0;
    } else {
        long long size=arr.size();
        for (long long i=0; i<size; i++) {
            long long j=i;
            while(sum<n) {
                sum+=arr[j];
                if (sum==n) {
                    count++;
                    break;
                } else if (sum>n) {
                    break;
                } else {
                    j++;
                }
            }
            sum=0;
        }
        cout<<count;
    }
    return 0;
}