package practice.javacore.stringbuilder;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyStringBuilder {
  private String string;
  private final History history = new History();

  MyStringBuilder() {
    this.string = "";
  }
  <T> MyStringBuilder(T t) {
    this.history.addLastNote(t.toString());
    this.string = t.toString();
  }

  @Override
  public String toString() {
    return this.string;
  }

  public <T> MyStringBuilder append(T t) {
    this.history.addLastNote(t.toString());
    this.string += t.toString();
    return this;
  }

  public MyStringBuilder undo() {
    this.history.deleteLastNote();
    this.string = this.history.getCurrentString();
    return this;
  }

  public static class History {
    LinkedList<String> history = new LinkedList<>();

    public void addLastNote(String value) {
      this.history.add(value);
    }
    public void deleteLastNote() throws NoSuchElementException {
      try {
        this.history.removeLast();
      } catch (NoSuchElementException ignored) {}
    }
    public String getCurrentString() {
      return String.join("", this.history);
    }
  }
}
