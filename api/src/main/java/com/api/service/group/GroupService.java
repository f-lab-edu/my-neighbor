package com.api.service.group;

import com.api.model.group.Group;
import com.api.repository.group.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    private final Clock clock;

    public Group save(Group group) {
        group.updateCreateAt(clock);
        return update(group);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public List<Group> findByCategoryId(Integer categoryId) {
        return groupRepository.findByCategoryId(categoryId);
    }

    public Optional<Group> findById(Long groupId) {
        return groupRepository.findById(groupId);
    }

    public Group updateGroup(Group group) {
        group.updateModifyAt(clock);
        return update(group);
    }

    public void deleteById(Long groupId) {
        groupRepository.deleteById(groupId);
    }

    public Group update(Group group) {
        return groupRepository.save(group);
    }
}
