package com.hokumus.course.dao.utils;

public interface IBaseDbOperation<T> {
	public boolean save(T temp);
	public boolean update(T temp);
	

}
