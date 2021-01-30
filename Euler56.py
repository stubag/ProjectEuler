# -*- coding: utf-8 -*-
"""
Created on Sat Jan 30 17:47:48 2021

@author: Operator
"""

max = 0
for num in range(1,100):
    for n2 in range(1,100):
        total = 0
        power = num ** n2
        power = list(str(power))
        for i in power:
            total += int(i)
        if total > max:
            max = total
print(max)
    
            

    