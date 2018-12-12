package com.jamesdube.unibot.repository;

import com.jamesdube.unibot.domain.Degree;
import com.jamesdube.unibot.utils.enums.Classification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface DegreeRepository extends JpaRepository<Degree,Long>{

    Stream<Degree> findDegreeByClassification(Classification classification);
}
