package pw.bshkola.model.service;

import java.util.List;

import pw.bshkola.model.service.exceptions.TransactionRollbackException;

public interface Service<WebObjectType> {
	
	public List<WebObjectType> findAll();
	
	public void save(WebObjectType object) throws TransactionRollbackException;
	
	public void saveOrUpdate(WebObjectType object) throws TransactionRollbackException;
	
	public void update(WebObjectType object) throws TransactionRollbackException;
	
	public void delete(WebObjectType object) throws TransactionRollbackException;

}
