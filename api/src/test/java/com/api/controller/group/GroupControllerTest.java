package com.api.controller.group;

import com.api.controller.ApiResult;
import com.api.dto.GroupDto;
import com.api.dto.CreateGroupRequest;
import com.api.model.group.Group;
import com.api.model.group.GroupPublicType;
import com.api.service.group.GroupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class GroupControllerTest {

    GroupController groupController;

    @Mock
    private GroupService groupService;

    List<Group> groups;

    Group group1;

    Group group2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        group1 = Group.builder().
                groupId(1L)
                .categoryId(1)
                .leaderId(24L)
                .name("test-group1")
                .desc("test group 1 desc")
                .publicType(GroupPublicType.PUBLIC)
                .maxNum(10)
                .regionId(1)
                .build();

        group2 = Group.builder().
                groupId(2L)
                .categoryId(1)
                .leaderId(4254L)
                .name("test-group2")
                .desc("test group 2 desc")
                .publicType(GroupPublicType.PRIVATE)
                .maxNum(120)
                .regionId(31)
                .build();

        groups = new ArrayList<>();
        groups.add(group1);
        groups.add(group2);

        groupController = new GroupController(groupService);
    }

    @Test
    public void test_getGroups_isSuccess() {
        when(groupService.findAll()).thenReturn(groups);

        ApiResult<List<GroupDto>> groupListResult = groupController.groupList();

        assertThat(groupListResult.getResponse()).isNotNull();
        assertThat(groupListResult.getResponse().size()).isEqualTo(2);
    }

    @Test
    public void test_createGroup_isSuccess() {
        CreateGroupRequest request = new CreateGroupRequest(10, 1L, "create-test-group", null, null, GroupPublicType.PUBLIC, 10, 1, 4);
        when(groupService.save(any(Group.class))).thenReturn(group1);

        ApiResult<GroupDto> result = groupController.groupSave(request);

        assertThat(result.getResponse()).isNotNull();
        assertThat(result.getResponse().getGroupId()).isNotNull();
    }
}
