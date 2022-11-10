package calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalculationEngine {
    private int result;
    private Operation currentOperation;
    private Deque<Integer> memory;

    public CalculationEngine(){
        this.result = 0;
        this.currentOperation = null;
        memory = new ArrayDeque<>();
    }

   public void pushNumber(int number) {
        if (this.currentOperation != null) {
            currentOperation.addOperand(number);

            if (currentOperation.isCompleted()) {
                this.result = currentOperation.getResult();
                this.currentOperation = null;
            }
        } else {
            this.result = number;
        }
    }

    void pushOperation(Operation operation) {
        if (operation.isCompleted()) {
            this.pushNumber(operation.getResult());
        } else {
            this.currentOperation = operation;
            this.pushNumber(this.result);
        }
    }

    int getCurrentResult() {
        return this.result;
    }

    public Deque<Integer> getMemory() {
        return memory;
    }
}
