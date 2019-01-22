package com.jamesdube.unibot.repository;

import com.jamesdube.unibot.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {

    Subject findByCode(String code);
}
