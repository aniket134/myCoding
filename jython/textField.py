from java import awt, applet

class TextField(applet.Applet):
	def init(self):
		self.t1 = awt.TextField('Hello there!',12)
		self.add(self.t1)
		
if __name__ == '__main__':
	import pawt
	pawt.test(TextField())
