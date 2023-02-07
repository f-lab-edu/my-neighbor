package com.api.repository.group;

import com.api.model.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Group save(Group group);

    List<Group> findAll();

    List<Group> findByCategoryId(Integer categoryId);

    @Query("SELECT g FROM Group g WHERE g.groupId IN (:groupIds)")
    List<Group> findAllByGroupIds(@Param("groupIds") List<Long> groupIdList);

    Optional<Group> findById(Long groupId);

    void delete(Group group);
}
