package name.chenyuelin.ejb.demo.sample;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SayHello
 */
@Stateless
@Remote(SayHelloRemote.class)
public class SayHello implements SayHelloRemote {

	@Override
	public String say() {
		return "Hello EveryBody";
	}

}
