package com.imp.sessionfactory;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.StatelessSessionBuilder;
import org.hibernate.TypeHelper;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryImp implements SessionFactory {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Session session = null;

	@Override
	public EntityManager createEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityManager createEntityManager(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityManager createEntityManager(SynchronizationType synchronizationType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityManager createEntityManager(SynchronizationType synchronizationType, Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CriteriaBuilder getCriteriaBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistenceUnitUtil getPersistenceUnitUtil() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNamedQuery(String name, Query query) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T unwrap(Class<T> cls) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void addNamedEntityGraph(String graphName, EntityGraph<T> entityGraph) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> List<EntityGraph<? super T>> findEntityGraphsByType(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Metamodel getMetamodel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reference getReference() throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsFetchProfileDefinition(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, ClassMetadata> getAllClassMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getAllCollectionMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cache getCache() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassMetadata getClassMetadata(Class arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassMetadata getClassMetadata(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionMetadata getCollectionMetadata(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getCurrentSession() throws HibernateException {
		// TODO Auto-generated method stub
		return session;
	}

	@Override
	public Set getDefinedFilterNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilterDefinition getFilterDefinition(String arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryOptions getSessionFactoryOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statistics getStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeHelper getTypeHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isClosed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Session openSession() throws HibernateException {
		
		if(session == null)
			session = new Configuration().configure().buildSessionFactory().openSession();
		
		return session;
	}

	@Override
	public StatelessSession openStatelessSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatelessSession openStatelessSession(Connection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionBuilder withOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatelessSessionBuilder withStatelessOptions() {
		// TODO Auto-generated method stub
		return null;
	}

}
