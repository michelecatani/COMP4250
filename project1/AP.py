## necessary import statements

import itertools
import math
import timeit

## first we count the number of baskets in the file

print("AP ALGO INCOMING")

count = 0

f = open('retail.txt', 'r')

theMax = 0

for line in f:
    count += 1
    for x in line.split():
        theMax = max(theMax, int(x))

f.seek(0)

## now, we get input about how much of the data the user would like to analyze and what the support threshold is to be

print("What percent of the data would you like to analyze?")

percentChunk = input()

print("\nWhat would you like your support threshold to be? (Enter in percent)")

support = input()

## now, we compute how many baskets we need to analyze and how many baskets constitute the support threshold

basketsAnalyzed = math.ceil((count * (int(percentChunk) / 100)))

supportThreshold = math.ceil((basketsAnalyzed * (int(support) / 100)))

print("So, we will analyze " + str(basketsAnalyzed) + " baskets, and if there are " + str(supportThreshold) + " occurences then the item is frequent.") 

## start the timer

start = timeit.default_timer()

## iterate through the file and obtain the counts

listOfSingletons = [0] * (theMax + 1)

count = 0

for i in f:
    if count >= basketsAnalyzed:
        break
    count += 1
    for x in i.split():
        listOfSingletons[int(x)] += 1

f.seek(0)

## count the frequent items

frequentSings = []

for i in range(len(listOfSingletons)):
    if listOfSingletons[i] >= supportThreshold:
        frequentSings.append(i)

## now, pass two where we count the pairs of frequent items

listOfCandidatePairs = list(itertools.combinations(frequentSings, 2))

dictPairs = {}

for j in listOfCandidatePairs:
    count = 0
    for i in f:
        if count >= basketsAnalyzed:
            break
        count += 1
        first = False
        second = False
        for x in i.split():
            if int(x) == j[0]:
                first = True
            if int(x) == j[1]:
                second = True
            if first and second:
                dictPairs[j] = dictPairs.get(j, 0) + 1
                break
    f.seek(0)

print("\nThis is the list of candidate pairs and their counts:")
print(dictPairs)

## output the frequent items

dictPairs = {key:val for key, val in dictPairs.items() if val >= supportThreshold}

print("\nThese are the frequent items:")
print(dictPairs)

# end the time

end = timeit.default_timer()

print("\nThis took " + str(end - start) + " seconds")

