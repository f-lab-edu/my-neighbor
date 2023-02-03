package com.api.service.group;

import com.api.error.NotFoundException;
import com.api.model.group.Group;
import com.api.repository.group.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
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

    private final MessageSourceAccessor messageSourceAccessor;

    @Transactional
    public Group save(Group group) {
        group.updateCreateAt(clock);
        return groupRepository.save(group);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Group> findByCategoryId(Integer categoryId) {
        return groupRepository.findByCategoryId(categoryId);
    }

    public Optional<Group> findById(Long groupId) {
        return groupRepository.findById(groupId);
    }

    @Transactional
    public Group updateGroup(Group group) {
        Group target = findById(group.getGroupId()).orElseThrow(() -> new NotFoundException(messageSourceAccessor, Group.class, group.getGroupId()));
        target.setCategoryId(group.getCategoryId());
        target.setLeaderId(group.getLeaderId());
        target.setName(group.getName());
        target.setDesc(group.getDesc());
        target.setGroupImageUrl(group.getGroupImageUrl());
        target.setMaxNum(group.getMaxNum());
        target.setCityId(group.getCityId());
        target.setTownId(group.getTownId());
        target.updateModifyAt(clock);
        return target;
    }

    @Transactional
    public Group deleteGroup(Long groupId) {
        Group target = findById(groupId).orElseThrow(() -> new NotFoundException(messageSourceAccessor, Group.class, groupId));
        groupRepository.delete(target);
        return target;
    }
}
