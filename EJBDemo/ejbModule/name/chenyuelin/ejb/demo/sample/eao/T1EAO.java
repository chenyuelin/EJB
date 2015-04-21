package name.chenyuelin.ejb.demo.sample.eao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import name.chenyuelin.ejb.demo.sample.model.T1;

/**
 * Session Bean implementation class T1EAO
 */
@Stateless
@LocalBean
public class T1EAO {

	@PersistenceContext
    private EntityManager em;

	public T1 getT1(int id){
		return em.find(T1.class, (byte)id);
	}
}
