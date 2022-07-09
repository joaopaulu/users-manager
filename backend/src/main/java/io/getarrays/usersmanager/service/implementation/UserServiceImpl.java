package io.getarrays.usersmanager.service.implementation;

import io.getarrays.usersmanager.entity.User;
import io.getarrays.usersmanager.repository.UserRepository;
import io.getarrays.usersmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  public Page<User> getUsers(String name, int page, int size) {
    log.info("Fetching users for page {} of size {}", page, size);
    return userRepository.findByNameContaining(name, PageRequest.of(page, size));
  }

}
