package dao;

import exception.AdminException;

public interface AdminsDao {
     public boolean loginAdmin(String username,String passworld) throws AdminException;
}
