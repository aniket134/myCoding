sample = []
sample += [1]
print(sample)
sample.append(2)
print(sample)
sample += [1, 2]
print(sample)
class object():
	def __init__(self, id):
		self.id = id
def get_list():
	o1 = object(1)
	o2 = object(2)
	links = [o1, o2]
	return links
