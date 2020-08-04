#include <iostream>
#include <algorithm>
#include <string>


using namespace std;

int arr[1001];
// int* lcs(int arr[], int start, string s1, string s2, int max) {
//     int t=start;
//     int size1=s1.size();
//     int size2=s2.size();
//     if (start>size2 || size1<=0) {
//         return arr;
//     } else {
//         if (s1.find(s2.at(start-1))!=-1) {
//             arr[start]=max+1;
//             while(t<=size1) {
//                 int find=s1.find(s2.at(t-1));
//                 if (find!=-1) {
//                     lcs(arr,start+1,s1.substr(find+1,size1-find-1), s2,arr[start]);
//                 }
//                 t++;
//             }
//         }
//         return arr;
//     }
// }
int main() {
    string s1, s2;
    cin >> s1 >> s2;
    int *result=lcs(arr, 1, s1, s2,0);
    int max=0;

    // for (int i=0; i<s2.size(); i++) {
    //     if(arr[i+1]>max) {max=arr[i+1];}
    // }
    for (int i=1; i<=s2.size(); i++) {
        cout<<arr[i]<<endl;
    }
    cout<<max;

    return 0;
}
