package name.chenyuelin.ejb.demo.sample.eao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerHelper {
	@PersistenceContext(unitName="JPATestDB2")
    private EntityManager JPATestDB2;
	
	@PersistenceContext(unitName="JPATestDB")
    private EntityManager JPATestDB;
}
