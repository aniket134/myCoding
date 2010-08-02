class A(object):
    def foo(self):
        print "foo"

class B(A):
    def foo(self):
	print('B.foo')
        super(B, self).foo()

myB = B()
myB.foo()

