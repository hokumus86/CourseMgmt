package com.hokumus.course.dao.utils;

import java.util.List;

public interface IBaseDbOperation<T> {
	public boolean save(T temp);
	public boolean update(T temp);
	public boolean delete(T temp);
	public List<T> getAll(T temp);
	public List<T> findSavedId(T temp);
	public T findUserOthers(T temp);
	public T findUser(T temp);
	public List<T> searchRecord(T temp);
	public List<T> seacrh(String kolonadi, String veri, T temp);
	public T find(T temp, int id);
	

}
