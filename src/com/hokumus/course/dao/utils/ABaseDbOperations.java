package com.hokumus.course.dao.utils;

import java.lang.reflect.Field;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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

	@Override
	public boolean delete(T temp) {
		try {
			openSession();
			ss.delete(temp);
			closeSession();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			closeSessionForRollback();
			return false;
		}
	}

	@Override
	public T find(T temp, int id) {
		try {
			openSession();
			Criteria cr = ss.createCriteria(temp.getClass());
			cr.add(Restrictions.eq("id", id));
			T t = (T) cr.list().get(0);
			closeSession();
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			closeSessionForRollback();
			return null;
		}
	}

	@Override
	public List<T> seacrh(String kolonadi, String veri, T temp) {
		try {
			openSession();
			Criteria cr = ss.createCriteria(temp.getClass());
			cr.add(Restrictions.eq(kolonadi, veri));
			List<T> liste = cr.list();
			closeSession();
			return liste;
		} catch (Exception e) {
			e.printStackTrace();
			closeSessionForRollback();
			return null;
		}
	}

	@Override
	public List<T> searchRecord(T temp) {
		try {
			List<T> listem = null;

			Class cl = temp.getClass();
			Field[] fl = cl.getDeclaredFields();

			openSession();
			Criteria cr = ss.createCriteria(temp.getClass());
			for (int i = 0; i < fl.length; i++) {
				fl[i].setAccessible(true);
				if (fl[i].get(temp) != null && !fl[i].get(temp).toString().equals("0")) {

					cr.add(Restrictions.ilike(fl[i].getName(), "%" + fl[i].get(temp) + "%"));

				}
			}
			listem = cr.list();
			closeSession();
			return listem;
		} catch (Exception e) {
			e.printStackTrace();
			closeSessionForRollback();
			return null;
		}
	}
	
	@Override
	public T findUser(T temp) {
		try {
			Class cl = temp.getClass();
			if (cl.getName().equals("com.hokumus.course.management.model.kullanici.Users")) {
				Field[] fl = cl.getDeclaredFields();
				openSession();
				Criteria cr = ss.createCriteria(temp.getClass());
				for (int i = 0; i < fl.length; i++) {
					fl[i].setAccessible(true);
					if (fl[i].getName().equals("userName") || fl[i].getName().equals("password")) {
						if (fl[i].get(temp) != null && !fl[i].get(temp).toString().equals("0")) {
							cr.add(Restrictions.eq(fl[i].getName(), fl[i].get(temp)));

						}
					}

				}
				return (T) cr.uniqueResult();

			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			closeSessionForRollback();
			return null;
		}

	}
	
	@Override
	public T findUserOthers(T temp) {
		try {
			Class cl = temp.getClass();
			Field[] fl = cl.getDeclaredFields();
			openSession();
			Criteria cr = ss.createCriteria(temp.getClass());
			for (int i = 0; i < fl.length; i++) {
				fl[i].setAccessible(true);
				if (fl[i].getName().equals("ad") || fl[i].getName().equals("soyad")) {
					if (fl[i].get(temp) != null && !fl[i].get(temp).toString().equals("0")) {
						cr.add(Restrictions.eq(fl[i].getName(), fl[i].get(temp)));

					}
				}

			}
			return (T) cr.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			closeSessionForRollback();
			return null;
		}

	}

	@Override
	public List<T> findSavedId(T temp) {
		try {
			List<T> listem = null;

			Class cl = temp.getClass();
			Field[] fl = cl.getDeclaredFields();

			openSession();
			Criteria cr = ss.createCriteria(temp.getClass());
			for (int i = 0; i < fl.length; i++) {
				fl[i].setAccessible(true);
				if (fl[i].get(temp) != null && !fl[i].get(temp).toString().equals("0")) {
					cr.add(Restrictions.eq(fl[i].getName(), fl[i].get(temp)));

				}
			}
			listem = cr.list();
			return listem;
		} catch (Exception e) {
			e.printStackTrace();
			closeSessionForRollback();
			return null;
		}
	}

}
