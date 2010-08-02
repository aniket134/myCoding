#import psyco
#psyco.full()
def getHash(lis):
	hash = {}
	for l in lis:
		if l in hash.keys():
			hash[l] = hash[l] + 1
		else:
			hash[l] = 1
	return hash

first = raw_input()
noOfCases = range(int(first))
for i in noOfCases:
	line = raw_input()
	numbers = line.split()
	A = numbers[0]
	B = numbers[1]
	intA = int(A)
	intB = int(B)
	permuts = 0
	while intB >= intA:
		lenA = str(intA)
		intA2 = intA*2
		len2A = str(intA2)
		if int(lenA[0]) < 5 and getHash(lenA) == getHash(len2A):
			permuts = permuts + 1
		intA = intA + 1
	print(str(permuts))
