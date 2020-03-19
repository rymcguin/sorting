'''
    Author: Ryan McGuiness
    Day 14 Classwork - Problem #1
    
    To finish this problem do the following steps:
    - Fill in the author field in line 2 with your name.
    - Run/Execute this program succesfully.
    - Type the output of the program between the ***** below
    - upload this file to Classwork 14 assignment on canvas

    *****
    200.58571428571426
    *****
'''

weight_measurements = [201.9, 200.4, 202.1, 198.6, 201.3, 199.7, 200.1]

sum_weight = 0
count_weight = 0

for measure in weight_measurements:
	sum_weight = sum_weight + measure
	count_weight = count_weight + 1

avg_weight = sum_weight / count_weight
print(avg_weight)

