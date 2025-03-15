#  Given an array of integers and a target value, determine the number of pairs of array elements that have a
# difference equal to the target value.

# Example 
# k=1
# arr = [1,2,3,4]

# thre are three values that differ by k = 1: 2-1 = 1, 3-2 = 1, and 4-3 = 1. Return 3.

def pairs2(k , arr):
    # Create an empty set to track visited numbers
    visited = set()
    count = 0
    
    # Iterate through each number in the array
    for num in arr:
        # Check if num + k or num - k exists in the set
        if (num + k) in visited:
            count += 1
        if (num - k) in visited:
            count += 1
        
        # Add the current number to the set
        visited.add(num)
    
    return count

def pairs(k , A):

    elements = set(A)
    count = 0
    for e in A:
        if (e-k) in elements:
            count = count + 1
    return count

print(pairs(1, [1, 2, 3, 4]))  # 3
print(pairs(1, [1, 5, 3, 4, 2]))  # 3 / 4
print(pairs(1, [1, 2, 3, 9, 5]))  # 2
print(pairs(4, [1, 2, 3, 9, 5]))  # 2
print(pairs(5, [4, 2, 3, 9, 5]))  # 1
