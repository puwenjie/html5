package com.pu.dao;

import com.pu.pojo.Filepathinform;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Filepathinform entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.pu.pojo.Filepathinform
 * @author MyEclipse Persistence Tools
 */

public class FilepathinformDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(FilepathinformDAO.class);
	// property constants
	public static final String FILENAME = "filename";
	public static final String FILEPATHZIP = "filepathzip";
	public static final String FILEPATHURL = "filepathurl";
	public static final String PREIMGURL = "preimgurl";
	public static final String DOWNTIMES = "downtimes";

	public void save(Filepathinform transientInstance) {
		getSession().beginTransaction(); 
		log.debug("saving Filepathinform instance");
		   getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		 getSession().getTransaction().commit();    
		 getSession().flush();    
		 getSession().close();
	}

	public void delete(Filepathinform persistentInstance) {
		log.debug("deleting Filepathinform instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Filepathinform findById(java.lang.Integer id) {
		log.debug("getting Filepathinform instance with id: " + id);
		try {
			Filepathinform instance = (Filepathinform) getSession().get(
					"com.pu.pojo.Filepathinform", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Filepathinform instance) {
		log.debug("finding Filepathinform instance by example");
		try {
			List results = getSession()
					.createCriteria("com.pu.pojo.Filepathinform")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Filepathinform instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Filepathinform as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFilename(Object filename) {
		return findByProperty(FILENAME, filename);
	}

	public List findByFilepathzip(Object filepathzip) {
		return findByProperty(FILEPATHZIP, filepathzip);
	}

	public List findByFilepathurl(Object filepathurl) {
		return findByProperty(FILEPATHURL, filepathurl);
	}

	public List findByPreimgurl(Object preimgurl) {
		return findByProperty(PREIMGURL, preimgurl);
	}

	public List findByDowntimes(Object downtimes) {
		return findByProperty(DOWNTIMES, downtimes);
	}

	public List findAll() {
		log.debug("finding all Filepathinform instances");
		try {
			String queryString = "from Filepathinform";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Filepathinform merge(Filepathinform detachedInstance) {
		log.debug("merging Filepathinform instance");
		try {
			Filepathinform result = (Filepathinform) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Filepathinform instance) {
		log.debug("attaching dirty Filepathinform instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Filepathinform instance) {
		log.debug("attaching clean Filepathinform instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}