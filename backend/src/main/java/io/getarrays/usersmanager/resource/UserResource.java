package io.getarrays.usersmanager.resource;

import io.getarrays.usersmanager.entity.HttpResponse;
import io.getarrays.usersmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {
  private final UserService userService;

  @GetMapping
  public ResponseEntity<HttpResponse>getUsers(@RequestParam Optional<String> name,
                                              @RequestParam Optional<Integer> page,
                                              @RequestParam Optional<Integer> size){
    return ResponseEntity.ok().body(
            HttpResponse.builder()
                    .timeStamp(now().toString())
                    .date(Map.of("page", userService.getUsers(name.orElse(""), page.orElse(0), size.orElse(10))))
                    .message("Users Retrieved")
                    .status(HttpStatus.OK)
                    .statusCode(HttpStatus.OK.value())
                    .build()
    );

  }
}
