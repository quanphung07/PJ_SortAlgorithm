package hust.sortsystem.sort.algorithm;

public abstract class ThreadExtend implements Runnable {
    protected Thread thread = null;
    protected double timeDelay = 2000;
    private boolean suspended = false;

    public boolean getSuspended() {
        return suspended;
    }

    public void setTimeDelay(double timeDelay) {
        this.timeDelay = timeDelay;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public void start()
    {
        if (thread == null)
        {
            thread = new Thread (this);
            thread.start();
        }
    }
    public void suspend() {
        suspended = true;
    }
    public synchronized void resume() {
        suspended = false;
        notify();
    }

    public boolean isAlive() {
        if(thread == null) return false;
        return thread.isAlive();
    }

    public void stopThread() {
        if(isAlive()) {
            resume();
            thread.interrupt();
        }
    }
}
