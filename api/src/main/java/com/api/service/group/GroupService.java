package com.api.service.group;

import com.api.error.NotFoundException;
import com.api.model.group.Group;
import com.api.repository.group.GroupRepository;
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
        Group target = findById(group.getGroupId()).orElseThrow(() -> new NotFoundException(Group.class, group.getGroupId()));
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
        Group target = findById(groupId).orElseThrow(() -> new NotFoundException(Group.class, groupId));
        groupRepository.delete(target);
        return target;
    }
}
