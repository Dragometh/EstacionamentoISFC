package DAO;

import java.util.List;

public interface Interface<T> {
	public abstract void Create(T obj);
    public abstract List<T> Retrieve();
    public abstract T Retrieve(int id);
    public abstract void Update(int id, T obj);
    public abstract void Delete(T obj);
}
