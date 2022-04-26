import itertools

numbers = [num for num in range(1, 11)]

allCombs = []

for L in range(len(numbers) + 1):
    for subset in itertools.combinations(numbers, L):
        allCombs.append(subset)

validCombs = []

for i in allCombs:

    product = 1

    for j in i:

        product *= j
    
    if product <= 100 and len(i) > 0:
        validCombs.append(i)

print("The itemsets that are frequent are: ")
print(validCombs)
print("There are " + str(len(validCombs) - 1) + " frequent itemsets")

