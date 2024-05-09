package com.jee.repository;

import com.jee.entity.Stu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuRepository extends JpaRepository<Stu, Long> {
}