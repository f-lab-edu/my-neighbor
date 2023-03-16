package com.nb.api.controller.connection;

import com.nb.api.controller.ApiResult;
import com.nb.api.controller.group.GroupMapper;
import com.nb.api.controller.user.UserMapper;
import com.nb.api.dto.ConnectionDto;
import com.nb.api.dto.GroupDto;
import com.nb.api.dto.UserDto;
import com.nb.api.event.GroupJoinPublisher;
import com.nb.api.service.connection.ConnectionService;
import com.nb.core.model.connection.Connection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/connection")
public class ConnectionController {

    private final ConnectionService connectionService;

    private final GroupJoinPublisher groupJoinPublisher;

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResult<String> pubConnectionSave(@RequestBody ConnectionDto dto) {
        groupJoinPublisher.publish(dto);
        return ApiResult.Ok("success");
    }

    // 특정 그룹에 가입된 사용자 전체 조회
    @GetMapping("/group/{groupId}")
    public ApiResult<List<UserDto>> getJoinedUsers(@PathVariable Long groupId) {
        List<Long> userIdList = connectionService.findAllByGroupId(groupId);

        return ApiResult.Ok(
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

        return ApiResult.Ok(
            connectionService.findByGroupIdIn(groupIdList)
                .stream()
                .map(GroupMapper::toDto)
                .collect(toList())
        );
    }

    // 그룹 탈퇴
    @DeleteMapping("/{groupId}/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResult<ConnectionDto> connectionRemove(@PathVariable Long groupId, @PathVariable Long userId) {
        return ApiResult.Ok(
                ConnectionMapper.toDto(connectionService.deleteConnection(new Connection(groupId, userId)))
        );
    }
}
