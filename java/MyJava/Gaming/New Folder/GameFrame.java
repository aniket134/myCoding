class GameFrame extends Frame{

protected Panel p;
protected MenuItem newItem,abortItem;
protected GameManager gm;
protected int width,height;
protected OptionsDialog d;

public GameFrame(Applet app,int width,int height){
super("Alien Landing");
this.width=width;
this.height=height;
gm=(GameManager)app;
resize(width+13,height+65);
setResizable(false);
Menubar menubar = new MenuBar();
Menu m1 = new Menu("Game");
newItem = new MenuItem("NewGame");
m1.add(newItem);
abortItem = new MenuItem("Abort Game");
m1.add(abortItem);
m1.add(new MenuItem("Exit");
Menu m2 = new Menu("Options");
m2.add(new MenuItem("Change"));
menubar.add(m1);
menubar.add(m2);
setMenuBar(menubar);
p = new Panel();
p.setLayout(new FlowLayout(FlowLayout.CENTER));
p.add(app);
setLayout(new BorderLayout());
add("Center",p);
setCursor(Frame.CROSSHAIR_CURSOR);
show();
}

public void gameOver(){
abortItem.disable();
newItem.enable();
}

public boolean action(Event e,Object o) {
if (e.target instanceof MenuItem) {
String s = (String)o;
if (e.target == newItem) {
gm.newGame();
newItem.disable();
abortItem.enable();
}
else if (e.target == abortItem) {
gm.gameOver();
}
else if (s.equals("Exit")) {
hide();
gm.stop();
gm.destroy();
dispose();
}
else if (s.equals("Change")) {
d = new OptionsDialog(this,gm);
d.show();
}
return true;
}
else return false;
}
}