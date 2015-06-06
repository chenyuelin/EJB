package name.chenyuelin.ejb.demo2.sample.eao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import name.chenyuelin.ejb.demo2.sample.model3.Agent;

/**
 * Session Bean implementation class AgentEAO
 */
@Stateless
@LocalBean
public class AgentEAO {

	@PersistenceContext(unitName = "JPATestDB3")
	private EntityManager em;

	public Agent getAgent(byte id) {
		return em.find(Agent.class, id);
	}

	public Agent persist(String name) {
		Agent agent = new Agent();
		agent.setName(name);
		em.persist(agent);
		return agent;
	}

	public boolean update(byte id, String name) {
		Agent agent = em.find(Agent.class, id);
		if (agent == null) {
			return false;
		} else {
			agent.setName(name);
			em.merge(agent);
			return true;
		}
	}

	public void flush() {
		em.flush();
	}
}
