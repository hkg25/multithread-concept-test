package thread.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {
	 
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static void f( List l ) {
        l.add( 2 );
    }
 
    /**
     * @param args
     */
    @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void main(String[] args) {
        List copyOnWriteList = new CopyOnWriteArrayList();
        List simpleList = new ArrayList();
        copyOnWriteList.add( 1 );
        simpleList.add( 1 );
        Iterator copyOnWriteIterator1 = copyOnWriteList.iterator();
        Iterator simpleListIterator1 = simpleList.iterator();
        f( copyOnWriteList );
        Iterator copyOnWriteIterator2 = copyOnWriteList.iterator();
        Iterator simpleListIterator2 = simpleList.iterator();
        // debug point on the output line just below
        System.out.println(copyOnWriteList);
    }
 
}