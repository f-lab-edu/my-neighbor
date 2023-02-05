package com.api.service.group;

import com.api.model.group.Group;
import com.api.repository.group.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.MessageSourceAccessor;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class GroupServiceTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    GroupService groupService;

    @Mock
    GroupRepository groupRepository;

    @Mock
    private Clock clock;

    private Group group;

    private Group resultGroup;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        String fixedTime = "2023-01-22T10:05:23.653Z";
        when(clock.instant()).thenReturn(Instant.parse(fixedTime));
        when(clock.getZone()).thenReturn(ZoneId.systemDefault());

        groupService = new GroupService(groupRepository, clock);

        group = Group.builder()
                .categoryId(5)
                .leaderId(1L)
                .name("service test group")
                .publicType("PRIVATE_GROUP")
                .build();

        resultGroup = Group.builder()
                .groupId(1L)
                .categoryId(3)
                .leaderId(2L)
                .name("service test result group")
                .publicType("PUBLIC_GROUP")
                .build();
    }

    @Test
    void 그룹을_생성한다() {
        when(groupRepository.save(any(Group.class))).thenReturn(resultGroup);

        groupService.save(group);

        assertThat(group.getCreateAt()).isEqualTo(LocalDateTime.now(clock));
    }

    @Test
    void 그룹을_수정한다() {
        when(groupRepository.findById(any())).thenReturn(Optional.ofNullable(resultGroup));

        Group res = groupService.updateGroup(resultGroup);

        assertThat(res.getModifyAt()).isEqualTo(LocalDateTime.now(clock));

    }
}
