package com.example.userservice.jpa;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    //함수 이름을 이렇게 하면 자동으로 컬럼 지정해서 연결해줌
    UserEntity findByUserId(String userId);

    UserEntity findByEmail(String username);


}
