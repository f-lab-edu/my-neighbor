package com.api.repository.group;

import com.api.model.group.Group;

import java.util.List;
import java.util.Optional;

public interface GroupRepository {

    List<Group> findByCategoryId(Integer categoryId);

    Optional<Group> findById(Long userId);

    Group saveGroup(Integer categoryId, Long leaderId, String name, String desc, String publicType);
}
