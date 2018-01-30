/**
 *
 */
package it.tafano.springboot.camel.example.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.tafano.springboot.camel.example.entity.ExampleEntity;

/**
 * @author tafano
 *
 */
@Transactional
@Repository
public class ExampleRepositoryImpl implements ExampleRepository {

	@Autowired
	private EntityManager entityManager;

	public ExampleEntity getExampleEntityById(int id) {
		return entityManager.find(ExampleEntity.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<ExampleEntity> getAllExampleEntitys() {
		String hql = "FROM ExampleEntity as atcl ORDER BY atcl.id";
		return entityManager.createQuery(hql).getResultList();
	}

	public void addExampleEntity(ExampleEntity exampleEntity) {
		entityManager.persist(exampleEntity);
	}

	public void updateExampleEntity(ExampleEntity exampleEntity) {
		ExampleEntity artcl = getExampleEntityById(exampleEntity.getId());
		artcl.setCode(exampleEntity.getCode());
		artcl.setDescription(exampleEntity.getDescription());
		entityManager.flush();
	}

	public void deleteExampleEntity(int id) {
		entityManager.remove(getExampleEntityById(id));
	}

	public boolean exampleEntityExists(String code, String description) {
		String hql = "FROM ExampleEntity as atcl WHERE atcl.code = ? and atcl.description = ?";
		int count = entityManager.createQuery(hql).setParameter(1, code).setParameter(2, description).getResultList().size();
		return count > 0 ? true : false;
	}
}
