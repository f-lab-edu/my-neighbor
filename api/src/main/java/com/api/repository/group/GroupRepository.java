package com.api.repository.group;

import com.api.model.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Group save(Group group);

    List<Group> findAll();

    List<Group> findByCategoryId(Integer categoryId);

    List<Group> findByGroupIdIn(List<Long> groupIdList);

    Optional<Group> findById(Long groupId);

    void delete(Group group);
}
