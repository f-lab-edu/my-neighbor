package com.api.service.group;

import com.api.model.group.Group;
import com.api.repository.group.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public Group saveGroup(Group group) {
        group.updateCreateAt();
        update(group);
        return group;
    }

    public List<Group> findByCategoryId(Integer categoryId) {
        return groupRepository.findByCategoryId(categoryId);
    }

    public Optional<Group> findById(Long userId) {
        return groupRepository.findById(userId);
    }

    public Group updateGroup(Group group) {
        group.updateModifyAt();
        update(group);
        return group;
    }

    public void update(Group group) {
        groupRepository.save(group);
    }
}
