package com.api.controller.connection;

import com.api.controller.ApiResult;
import com.api.controller.group.GroupMapper;
import com.api.controller.user.UserMapper;
import com.api.dto.ConnectionDto;
import com.api.dto.GroupDto;
import com.api.dto.UserDto;
import com.api.event.GroupJoinPublisher;
import com.api.model.connection.Connection;
import com.api.service.connection.ConnectionService;
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
import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/connection")
public class ConnectionController {

    private final ConnectionService connectionService;

    private final GroupJoinPublisher groupJoinPublisher;

    @PostMapping("/join")
    public ApiResult<String> pubConnectionSave(@RequestBody ConnectionDto dto) {
        groupJoinPublisher.publish(dto);
        return Ok("success");
    }

    // 특정 그룹에 가입된 사용자 전체 조회
    @GetMapping("/group/{groupId}")
    public ApiResult<List<UserDto>> getJoinedUsers(@PathVariable Long groupId) {
        List<Long> userIdList = connectionService.findAllByGroupId(groupId);

        return Ok(
            connectionService.findByUserIdIn(userIdList)
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
            connectionService.findByGroupIdIn(groupIdList)
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
