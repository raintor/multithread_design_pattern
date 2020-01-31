package ch12_Active_Object.base;

import ch12_Active_Object.base.activeobject.ActiveObject;
import ch12_Active_Object.base.activeobject.ActiveObjectFactory;

/**
 * @author: raintor
 * @Date: 2020/1/30 21:44
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();

        new MakerStringThread("Alice",activeObject).start();
        new MakerStringThread("Bob",activeObject).start();
        new DisplayStringThread("Click",activeObject).start();
    }
}
