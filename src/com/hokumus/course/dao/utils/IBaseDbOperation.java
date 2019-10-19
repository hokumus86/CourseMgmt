package com.hokumus.course.dao.utils;

import java.util.List;

public interface IBaseDbOperation<T> {
	public boolean save(T temp);
	public boolean update(T temp);
	public boolean delete(T temp);
	public List<T> getAll(T temp);
	

}
