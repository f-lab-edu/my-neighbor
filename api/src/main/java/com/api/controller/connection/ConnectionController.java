package com.api.controller.connection;

import com.api.controller.ApiResult;
import com.api.controller.group.GroupMapper;
import com.api.controller.user.UserMapper;
import com.api.dto.ConnectionDto;
import com.api.dto.GroupDto;
import com.api.dto.UserDto;
import com.api.model.connection.Connection;
import com.api.service.connection.ConnectionService;
import com.api.service.group.GroupService;
import com.api.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.api.controller.ApiResult.Ok;
import static com.api.controller.connection.ConnectionMapper.toDto;
import static com.api.controller.connection.ConnectionMapper.toEntity;
import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/connection")
public class ConnectionController {

    private final ConnectionService connectionService;

    private final GroupService groupService;

    private final UserService userService;

    // 사용자가 그룹 가입
    @PostMapping("/join")
    public ApiResult<ConnectionDto> connectionSave(@RequestBody ConnectionDto dto) {
        return Ok(
            toDto(connectionService.saveConnection(toEntity(dto)))
        );
    }

    // 특정 그룹에 가입된 사용자 전체 조회
    @GetMapping("/group/{groupId}")
    public ApiResult<List<UserDto>> getJoinedUsers(@PathVariable Long groupId) {
        List<Long> userIdList = connectionService.findAllByGroupId(groupId);

        return Ok(
            userService.findAllByUserIdList(userIdList)
                .stream()
                .map(UserMapper::toDto)
                .collect(toList())
        );
    }

    // 특정 사용자가 가입한 그룹 전체 조회
    @GetMapping("/user/{userId}")
    public ApiResult<List<GroupDto>> getJoinedGroups(@PathVariable Long userId) {
        List<Long> groupIdList = connectionService.findAllByUserId(userId);

        return Ok(
            groupService.findAllByGroupIdList(groupIdList)
                .stream()
                .map(GroupMapper::toDto)
                .collect(toList())
        );
    }

    // 그룹 탈퇴
    @DeleteMapping("/{groupId}/{userId}")
    public ApiResult<ConnectionDto> connectionRemove(@PathVariable Long groupId, @PathVariable Long userId) {
        return Ok(
                toDto(connectionService.deleteConnection(new Connection(groupId, userId)))
        );
    }
}
