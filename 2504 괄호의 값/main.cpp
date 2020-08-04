#include <iostream>
#include <string>
#include <stack>
using namespace std;

int check(string s) {
    int result=0;
    stack<int> calc;
    stack<char> st;
    //cout<<s.at(11)<<endl;
    char cur, temp, next, top;
    for (int i=0; i<s.length(); ++i) {
        //cout <<"adsfkjas;dlfkjasd;flkjasdf;lkads"<<endl;
        cur=s.at(i);
        cout<<cur<<endl;
        if (i==s.length()-1) {next='x';}
        else {next=s.at(i+1);}

        if (i==0 && (cur==']' ||cur==')')) {return -1;}
        if (i==s.length()-1 && (cur=='(' ||cur=='[')) {
            cout<<"dlkajf;laksdjf"<<endl;
            return -1;}

        //열린 괄호일 때
        if (cur=='[' || cur=='(') {
            if (next=='[' || next=='(') {
                st.push('*');
                ////cout << st.top()<<endl;
            } 
            st.push(cur);
                //cout << st.top()<<endl;

        } else {
        //else if (cur==']' || cur==')') {

            if (cur==')') {
                top=st.top();
                if(top=='(') {
                    st.pop();
                    //cout<<"sibal"<<endl;
                    //cout << "popped!!" <<st.top()<<endl;

                    //calc stack 에 값 푸쉬
                    calc.push(2);
                    // calc 스택 계산
                    top=st.top();
                    if (top=='*'|| top=='+') {
                        while(top=='*' || top=='+') {
                            //cout <<"here   cur top is "<<top;
                            if (top=='*') {
                            if (calc.empty()==1) {return -1;}

                                int a=calc.top();
                                calc.pop();
                            if (calc.empty()==1) {return -1;}

                                int b=calc.top();
                                calc.pop();
                                //cout <<"a is  "<<a<<"   b is   "<<b;
                                calc.push(a*b);
                            } else {
            if (calc.empty()==1) {return -1;}

                                int a=calc.top();
                                calc.pop();
            if (calc.empty()==1) {return -1;}

                                int b=calc.top();
                                calc.pop();
                                //cout <<"a is  "<<a<<"   b is   "<<b;

                                calc.push(a+b);
                            }
                            st.pop();
                            //cout<<"it's ok here   "<<st.empty();
                            if (st.empty()==1) {break;}
                            top=st.top();
                            
                            //cout <<calc.top()<<endl;

                        }
                    }
                    if (next=='(' || next=='[') {
                        st.push('+');
                //cout << st.top()<<endl;

                    }
                }
                else {return -1;}        
            } else {
                top=st.top();
                if(top=='[') {
                    st.pop();
                //cout << "popped!!!  "<<st.top()<<endl;

                    
                    //calc stack 에 값 푸쉬
                    calc.push(3);
                    // calc 스택 계산
                    //cout<<"sibal!@#$!@#"<<endl;
                    top=st.top();
                    if (top=='*'|| top=='+') {
                        while(top=='*' || top=='+') {
                            //cout <<"here   cur top is"<<top;

                            if (top=='*') {
                                int a=calc.top();
                                calc.pop();
                                int b=calc.top();
                                calc.pop();
                                calc.push(a*b);
                            } else {
                                int a=calc.top();
                                calc.pop();
                                int b=calc.top();
                                calc.pop();
                                calc.push(a+b);
                            }
                            st.pop();

                            if (st.empty()==1) {break;}
                            top=st.top();
                            
                            //cout <<calc.top()<<endl;
                        }
                    }
                    //cout<<"ajdfoiasjdfoiajsdfadjs"<<endl;
                     if (next=='(' || next=='[') {
                        st.push('+');
                //cout << st.top()<<endl;

                    }
                        //cout<<"555555555555"<<endl;
                }
                else {return -1;} 
            }
        //end if else
        }
    //cout<<"00000000000 cur i is   "<<i<<endl;
    //end for
    }
    //cout<<"ldkfjal;skdfj"<<endl;
    if (calc.empty()==1) {return -1;}
    cout<<"lsdkjf;laksdfj"<<endl;
    if (st.empty()!=1 && (st.top()=='(' || st.top()=='[' ||st.top()==')' ||st.top()==']')) {return -1;} 
    while(st.empty()!=1) {
        top=st.top();
        //cout <<"here   cur top is"<<top;
        
        if (top=='*') {
            if (calc.empty()==1) {return -1;}
            int a=calc.top();
            calc.pop();
            if (calc.empty()==1) {return -1;}

            int b=calc.top();
            calc.pop();
            calc.push(a*b);
        } else {
            if (calc.empty()==1) {return -1;}

            int a=calc.top();
            calc.pop();
            if (calc.empty()==1) {return -1;}

            int b=calc.top();
            calc.pop();
            calc.push(a+b);
        }
        st.pop();

        if (st.empty()==1) {break;}
        top=st.top();
        
        //cout <<calc.top()<<endl;

    }
    result=calc.top();
    return result;
}

int main() {
    string s;
    cin >> s;
    //bool ok=check(s);
    int result=0;
    if (check(s)!=-1) {
        result=check(s);
    }

    cout<<result;
    return 0;
}