package dataaccess;

import java.util.List;

import com.google.inject.ImplementedBy;

import models.User;

@ImplementedBy(UserDALImpl.class)
public interface UserDAL {

	public List<User> getAllUser();
	public User getUserById(Integer id);
}
