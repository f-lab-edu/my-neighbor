package com.api.service.group;

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

    @Transactional(readOnly = true)
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Group> findByCategoryId(Integer categoryId) {
        return groupRepository.findByCategoryId(categoryId);
    }

    @Transactional(readOnly = true)
    public Optional<Group> findById(Long groupId) {
        return groupRepository.findById(groupId);
    }

    @Transactional
    public Group updateGroup(Group group) {
        Group target = findById(group.getGroupId()).orElseThrow(() -> new RuntimeException("Group does not exist."));;
        target.updateCategoryId(group.getCategoryId());
        target.updateLeaderId(group.getLeaderId());
        target.updateName(group.getName());
        target.updateDesc(group.getDesc());
        target.updateGroupImageUrl(group.getGroupImageUrl());
        target.updateMaxNum(group.getMaxNum());
        target.updateCityId(group.getCityId());
        target.updateTownId(group.getTownId());
        target.updateModifyAt(clock);
        return target;
    }

    @Transactional
    public void deleteById(Long groupId) {
        groupRepository.deleteById(groupId);
    }
}
