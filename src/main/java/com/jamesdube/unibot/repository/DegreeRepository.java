package com.jamesdube.unibot.repository;

import com.jamesdube.unibot.domain.Degree;
import com.jamesdube.unibot.utils.enums.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface DegreeRepository extends JpaRepository<Degree,Long>{

    List<Degree> findByClassification(Classification classification);

    List<Degree> findDegreeByClassificationAndMinimumPointsLessThanEqual(Classification classification, int points);
}
