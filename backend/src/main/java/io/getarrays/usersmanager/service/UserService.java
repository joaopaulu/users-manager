package io.getarrays.usersmanager.service;

import io.getarrays.usersmanager.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {
  Page<User> getUsers(String name, int page, int size);
}
