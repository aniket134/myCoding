class My_class():
	def __init__(self, name):
		self.name = name
		print('inside My_class: ' + self.name)

I1 = My_class('sall')
I2 = My_class('bill')

print(I1.name)
print(I2.name)
