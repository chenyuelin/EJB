package name.chenyuelin.ejb.demo.sample;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Init;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class SingletonBean
 */
@Singleton
@Remote(SingletonBeanRemote.class)
public class SingletonBean implements SingletonBeanRemote {

	private int status;

	@PostConstruct
	public void construct() {
		System.out.println("construct");
	}

	@PreDestroy
	public void exist() {
		System.out.println("exist");
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
