package name.chenyuelin.ejb.demo.sample;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class T2Service
 */
@Stateless
@Remote(T2ServiceRemote.class)
public class T2Service implements T2ServiceRemote {

}
