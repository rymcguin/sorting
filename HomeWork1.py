'''
    Author: Ryan McGuiness
    Day 14 Homework - Problem #1

    Refer to the BlockPy figure in file D14HW1.doc located in your located in your 
    Computational_thinking folder.
    Convert the blocks in that figure into python code.
    Use this file for doing the translation.
    
    To finish this problem do the following steps:
    - Fill in the author field in line 2 with your name.
    - Run/Execute this program succesfully.
    - Upload this file to Homework 14 assignment on canvas
'''


episode_length_list = [52, 51, 49, 50, 50, 83]
sum_length = 0
for episode_length in episode_length_list:
    sum_length = sum_length + episode_length
print(sum_length)
