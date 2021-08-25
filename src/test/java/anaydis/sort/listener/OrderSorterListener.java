package anaydis.sort.listener;

import anaydis.sort.gui.SorterListener;

public class OrderSorterListener implements SorterListener {
    private int eq = 0;
    private int gr = 0;
    private int sw = 0;

    @Override
    public void box(int from, int to) { }

    @Override
    public void copy(int from, int to, boolean copyToAux) { }

    @Override
    public void equals(int i, int j) {
        eq++;
    }

    @Override
    public void greater(int i, int j) {
        gr++;
    }

    @Override
    public void swap(int i, int j) {
        sw++;
    }

    public int getEq() {
        return eq;
    }

    public int getGr() {
        return gr;
    }

    public int getSw() {
        return sw;
    }

    @Override
    public String toString() {
        return "OrderSorterListener { " +
                "eq = " + eq +
                ", gr = " + gr +
                ", sw = " + sw +
                '}';
    }
    public int getTotalOrder(){ return eq + gr + sw; }

}
