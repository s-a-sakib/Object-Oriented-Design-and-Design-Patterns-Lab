abstract class Handler {
    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handle(int request);
}

class LowLevelHandler extends Handler {
    @Override
    public void handle(int request) {
        if (request <= 10) {
            System.out.println("LowLevelHandler handled request: " + request);
        } else if (next != null) {
            next.handle(request);
        }
    }
}

class HighLevelHandler extends Handler {
    @Override
    public void handle(int request) {
        if (request > 10) {
            System.out.println("HighLevelHandler handled request: " + request);
        } else if (next != null) {
            next.handle(request);
        }
    }
}

public class ChainPatternDemo2 {
    public static void main(String[] args) {
        Handler low = new LowLevelHandler();
        Handler high = new HighLevelHandler();

        low.setNext(high);

        low.handle(5);   // handled by LowLevelHandler
        low.handle(20);  // handled by HighLevelHandler
    }
}
