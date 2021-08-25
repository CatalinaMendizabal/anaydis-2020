package anaydis.sort.gui;

import anaydis.animation.sort.gui.Main;
import anaydis.sort.SorterProviderImpl;

public class AnimationMain {
    public static void main(String[] args) {
        Main.animate(new SorterProviderImpl());
    }
}
