package com.hokumus.course.dao.utils;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hokumus.course.utils.MyHbUtil;

public abstract class ABaseDbOperations<T> implements IBaseDbOperation<T> {

	private Session ss;
	private Transaction tt;

	private void openSession() {
		ss = MyHbUtil.getSessionFactory().openSession();
		tt = ss.beginTransaction();
	}

	private void closeSession() {
		tt.commit();
		ss.close();
	}

	private void closeSessionForRollback() {
		tt.rollback();
		ss.close();
	}

	@Override
	public boolean save(T temp) {
		try {
			openSession();
			ss.save(temp);
			closeSession();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			closeSessionForRollback();
			return false;
		}
	}

	@Override
	public boolean update(T temp) {
		try {
			openSession();
			ss.update(temp);
			closeSession();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			closeSessionForRollback();
			return false;
		}
	}

	@Override
	public List<T> getAll(T temp) {
		try {
			openSession();
			Criteria cr = ss.createCriteria(temp.getClass());
			List<T> l = cr.list();
			closeSession();
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			closeSessionForRollback();
			return null;
		}
	}

}
