package com.agarcia.agracia.repository;

import com.agarcia.agracia.domain.GroupUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lito on 15/7/17.
 */
public interface GroupUserRepository  extends JpaRepository<GroupUser, Long> {
}