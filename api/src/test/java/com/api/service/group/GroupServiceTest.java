package com.api.service.group;

import com.api.model.group.Group;
import com.api.repository.group.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class GroupServiceTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Mock
    GroupRepository groupRepository;

    private Long groupId;

    private Integer categoryId;

    private Long leaderId;

    private String name;

    private String publicType;

    private LocalDateTime modifyAt;

    private LocalDateTime createAt;

    private Group group;

    private Group resultGroup;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        groupId = 10L;
        categoryId = 5;
        name = "service test group";
        leaderId = 1L;
        publicType = "PRIVATE_GROUP";
        modifyAt = LocalDateTime.now().minusDays(2);
        createAt = LocalDateTime.now().minusDays(30);

        group = new Group(categoryId, leaderId, name, null, publicType);
        resultGroup = new Group(groupId, categoryId, leaderId, name, null, null, publicType, 10, 0, 0, null, null);
    }

    @Test
    void 그룹을_생성한다() {
        when(groupRepository.save(any(Group.class))).thenReturn(resultGroup);

        GroupService groupService = new GroupService(groupRepository);
        Group result = groupService.save(group);

        assertThat(result).isNotNull();
        assertThat(result.getGroupId()).isNotNull();
        assertThat(result.getCreateAt()).isNotEqualTo(createAt);
    }

    @Test
    void 그룹을_수정한다() {
        when(groupRepository.save(any(Group.class))).thenReturn(resultGroup);

        GroupService groupService = new GroupService(groupRepository);
        Group result = groupService.updateGroup(resultGroup);

        assertThat(result).isNotNull();
        assertThat(result.getGroupId()).isNotNull();
        assertThat(result.getModifyAt()).isNotEqualTo(modifyAt);
    }
}
