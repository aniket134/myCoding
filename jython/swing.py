from javax.swing import *

frame = JFrame('Hello World!')
label = JLabel('Hello There', JLabel.CENTER)
frame.add(label)
textField = JTextField('Thus a text field was created', 20)
frame.add(textField)
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
frame.setSize(300, 300)
frame.show()
