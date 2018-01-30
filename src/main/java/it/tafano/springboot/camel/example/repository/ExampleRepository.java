package it.tafano.springboot.camel.example.repository;

import java.util.List;

import it.tafano.springboot.camel.example.entity.ExampleEntity;

public interface ExampleRepository {

	ExampleEntity getExampleEntityById(int id);

	List<ExampleEntity> getAllExampleEntitys();

	void addExampleEntity(ExampleEntity exampleEntity);

	void updateExampleEntity(ExampleEntity exampleEntity);

	void deleteExampleEntity(int id);

	boolean exampleEntityExists(String code, String description);

}