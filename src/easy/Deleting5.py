

def solution(N):
    s = str(N)
    maxv = float ('-inf')
    #print(s)
    for i,c in enumerate(s):
        if c == '5':
            s5 = s[:i] + s[i + 1:]
            n5 = int(s5)
            #print(n5)
            
            maxv = max(n5, int(s5))

    return maxv


print(solution(15958)) #
print(solution(-5859)) #
print(solution(-5000)) #
