package name.cyl.ebj;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class Ejb2
 */
@Stateless
public class Ejb2 implements Ejb2Remote, Ejb2Local {

    /**
     * Default constructor. 
     */
    public void say() {
    	System.out.println("I'm Ejb2.");
    }

}
