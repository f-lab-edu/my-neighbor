package com.api.repository.group;

import com.api.model.group.Group;

import java.util.List;
import java.util.Optional;

public interface GroupRepository {

    Group save(Group group);

    List<Group> findByCategoryId(Integer categoryId);

    Optional<Group> findById(Long userId);
}
