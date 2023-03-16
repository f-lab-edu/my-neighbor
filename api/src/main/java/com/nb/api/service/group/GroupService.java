package com.nb.api.service.group;

import com.nb.core.error.GroupNotFoundException;
import com.nb.core.model.group.Group;
import com.nb.core.repository.group.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    private final Clock clock;

    @Transactional
    public Group save(Group group) {
        group.updateCreateAt(clock);
        return groupRepository.save(group);
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
    
    @Transactional
    public Group updateGroup(Group group) {
        Group target = findById(group.getGroupId()).orElseThrow(GroupNotFoundException::new);
        target.setCategoryId(group.getCategoryId());
        target.setLeaderId(group.getLeaderId());
        target.setName(group.getName());
        target.setDesc(group.getDesc());
        target.setGroupImageUrl(group.getGroupImageUrl());
        target.setMaxNum(group.getMaxNum());
        target.setRegionId(group.getRegionId());
        target.updateModifyAt(clock);
        return target;
    }

    @Transactional
    public Group deleteGroup(Long groupId) {
        Group target = findById(groupId).orElseThrow(GroupNotFoundException::new);
        groupRepository.delete(target);
        return target;
    }
}
