package com.gcu.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gcu.model.ProcedureEntity;
import com.gcu.model.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>
{
	UserEntity findByUsernameContainingIgnoreCase(String username, String password);
}
