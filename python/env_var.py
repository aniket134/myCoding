import os
print(os.getenv('PATH'))
os.environ['CLASSPATH'] = os.getcwd() + '------it is set-------'
print(os.getenv('CLASSPATH'))

os.environ['CLASSPATH'] = os.getcwd() + '------it does not get added with =-------'
print(os.getenv('CLASSPATH'))

os.environ['CLASSPATH'] += os.getcwd() + '------it does gets added with +=-------'
print(os.getenv('CLASSPATH'))
