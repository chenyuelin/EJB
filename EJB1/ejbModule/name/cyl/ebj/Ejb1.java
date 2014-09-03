package name.cyl.ebj;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Ejb1
 */
@Stateless
@LocalBean
public class Ejb1 {

    /**
     * Default constructor. 
     */
    public void say() {
        System.out.println("I'm Ejb1.");
    }

}
