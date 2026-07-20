package practice.streamApi;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {
  private final int start;
  private final int end;
  private static final int THRESHOLD = 10;

  public FactorialTask(int n) {
    this(1, n);
  }

  private FactorialTask(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  protected Long compute() {
    if (end - start <= THRESHOLD) {
      long result = 1;
      for (int i = start; i <= end; i++) {
        result *= i;
      }
      return result;
    }

    int mid = (start + end) / 2;
    FactorialTask leftTask = new FactorialTask(start, mid);
    FactorialTask rightTask = new FactorialTask(mid + 1, end);

    leftTask.fork();
    rightTask.fork();

    long rightResult = rightTask.join();
    long leftResult = leftTask.join();

    return leftResult * rightResult;
  }
}