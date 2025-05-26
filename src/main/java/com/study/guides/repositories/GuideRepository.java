package com.study.guides.repositories;

import com.study.guides.models.Guide;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuideRepository extends CrudRepository<Guide, Long> {
    List<Guide> id(Long id);


}