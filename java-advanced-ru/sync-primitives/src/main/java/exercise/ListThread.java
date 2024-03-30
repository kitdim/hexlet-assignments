package exercise;


// BEGIN
public class ListThread extends Thread {
    private SafetyList list;
    public ListThread(SafetyList list) {
        this.list = list;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
// END
