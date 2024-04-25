package ku.cs.services;

import ku.cs.models.AdminList;

public interface Datasource<T> {
    T readData();

    void writeData(T data);
}
