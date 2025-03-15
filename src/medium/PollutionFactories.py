# An industrial company has N factories, each producing some pollution every month. 
# The company has decided to reduce its total fume emissions by equipping some of the factories with one or more filters. 
# Every such filter reduces the pollution of a factory by half. 
# When a second (or subsequent) filter is applied, it again reduces by half the remaining pollution emitted after fitting the existing filter(s). 
# For example, a factory that initially produces 6 units of pollution will generate 3 units with one filter, 1.5 units with two filters and 0.75 units with three filters. 

# You are given an array of N integers describing the amount of pollution produced by the factories. 
# Your task is to find the minimum number of filters needed to decrease the total sum of pollution by at least half. 

# Write a function: 

# class Solution { public int solution(int[] A); } 

# which, given an array of integers A of length N, returns the minimum number of filters needed to reduce the total pollution by at least half. 
# Examples: 
# 1. Given A = [5, 19, 8, 1), your function should return 3. The initial total pollution is 5 + 19 +8 +1 = 33. We install two filters at the factory producing 19 units and one filter at the factory producing 8 units. 
# Then the total pollution will be 5 + ((19 / 2) / 2) + (8 / 2) + 1 = 5 + 4.75 + 4 + 1 = 14.75 which is less than 33 / 2 = 16.5, so we have achieved our goal. 
# 2. Given A = [10, 10), your function should return 2, because we may install one filter at each factory. 
# 3. Given A = [3,0,5), your function should return 2, because it is sufficient to install one filter at each factory producing a non-zero amount of pollution.


import heapq

def solution(A):
    max_heap = []  # Initialize an empty max-heap
    total_pollution = 0
    
    # Add non-zero pollution factories to the max-heap and calculate total pollution
    for pollution in A:
        if pollution > 0:
            total_pollution += pollution
            heapq.heappush(max_heap, -float(pollution))  # Use negative values for max-heap
    
    target_pollution = total_pollution / 2
    filters = 0
    
    # Reduce pollution until total pollution is less than or equal to target pollution
    while max_heap and total_pollution > target_pollution:
        current = -heapq.heappop(max_heap)  # Get the maximum pollution (positive value)
        reduced = current / 2
        total_pollution -= (current - reduced)  # Update total pollution
        
        if reduced > 0:
            heapq.heappush(max_heap, -reduced)  # Push reduced pollution back to max-heap
        filters += 1
    
    return filters

# Example usage: 58 29
A = [10, 5, 20, 8, 15]
result = solution(A)
print(result)  # Output: 2 (number of filters required)


A1 = [5, 19, 8, 1] 
print(solution(A1)) # Output: 3
        
A2 = [10, 10]
print(solution(A2))  # Output: 2
        
A3 = [3, 0, 5];
print(solution(A3))  # Output: 2