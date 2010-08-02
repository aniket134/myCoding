# This file reads a txt file and removes recurrent lines.
# Outputs in out.txt.
f = open('in.txt')
of = open('out.txt', 'w+')
lines = f.readlines()
names = []
for line in lines:
	name = line.strip()
	if name not in names:
		names.append(name)
		if len(name) == 8:
			of.write(name + '\n')
