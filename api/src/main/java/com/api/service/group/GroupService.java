package com.api.service.group;

import com.api.model.group.Group;
import com.api.repository.group.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    public final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group createGroup() {
        return null;
    }

    public Group updateGroup() {
        return null;
    }

    public Group deleteGroup() {
        return null;
    }

}
