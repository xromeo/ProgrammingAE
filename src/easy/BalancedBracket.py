

def isBalanced(s):
    stack = []
    for i, c in enumerate(s):
        if c == '(' or c == '{' or c == '[':
            stack.append(c)
        else:
            if not stack:
                return 'no'
            sc = stack.pop()
            if sc != '(' and c == ')':
                return 'no'
            if sc != '[' and c == ']':
                return 'no'
            if sc != '{' and c == '}':
                return 'no'

    

    return 'yes' if not stack else 'no'



print(isBalanced("{[()]}")) #yes
print(isBalanced("{[(])}")) #no
print(isBalanced("{{[[(())]]}}")) #yes

print(isBalanced("()[{}()]([[][]()[[]]]{()})([]()){[]{}}{{}}{}(){([[{}([]{})]])}")); #yes
print(isBalanced("[)](][[([]))[)")); #no
