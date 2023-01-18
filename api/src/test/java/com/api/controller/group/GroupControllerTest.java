package com.api.controller.group;

import com.api.controller.ApiResult;
import com.api.dto.group.GroupDto;
import com.api.model.group.Group;
import com.api.service.group.GroupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class GroupControllerTest {

    @InjectMocks
    GroupController groupController;

    @Mock
    private GroupService groupService;

    private Integer categoryId;

    List<Group> groups;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Group group1 = new Group(1L, 1, 24L, "test-group1", "test group 1 desc", null, "PUBLIC_GROUP", 10, 1, 2, null, null);
        Group group2 = new Group(2L, 1, 4254L, "test-group2", "test group 2 desc", null, "PRIVATE_GROUP", 120, 31, 12, null, null);

        groups = new ArrayList<>();
        groups.add(group1);
        groups.add(group2);

        categoryId = 1;
        groupController = new GroupController(groupService);
    }

    @Test
    public void test_getGroups_isSuccess() {
        when(groupService.findByCategoryId(anyInt())).thenReturn(groups);

        ApiResult<List<GroupDto>> groupListResult = groupController.getGroups(categoryId);

        assertThat(groupListResult).isNotNull();
    }
}
