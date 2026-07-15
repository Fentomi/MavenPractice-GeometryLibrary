package practice.javacore.stringbuilder;

public class Main {
  public static void main(String[] args) {
    MyStringBuilder myStringBuilder = new MyStringBuilder(123);

    myStringBuilder.append(" Hello").append(" world!").append(123);
    System.out.println(myStringBuilder); //123 Hello world!123

    myStringBuilder.undo();
    System.out.println(myStringBuilder); //123 Hello world!
  }
}
