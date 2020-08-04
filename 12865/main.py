import sys
# w=weight list , v=value list
w=[]
v=[]

#n=number of items , W=weight limit
n,W=map(int, sys.stdin.readline().strip().split())

#getting input
for i in range (0, n) :
    wt, vt=map(int, sys.stdin.readline().strip().split())
    w.append(wt)
    v.append(vt)


dp=[[0 for x in range(W+1)] for x in range(n+1)]

for i in range (1, n+1) :
    for j in range (1, W+1) :
        if (j>=w[i-1]) :
            dp[i][j]=max(dp[i-1][j], v[i-1]+dp[i-1][j-w[i-1]])
        else :
            dp[i][j]=dp[i-1][j]

print(dp[n][W])


#잘 저장됐는지 확인용
# for i in range(n) :
#     print(w[i], end=' ')
# print("\n")
# for i in range(n) :
#     print(v[i], end=' ')
# print("\n")


#확인용
# for i in range (1, n+1) :
#     for j in range (1, W+1) :
#         print(dp[i][j], end=' ')
#     print("\n")