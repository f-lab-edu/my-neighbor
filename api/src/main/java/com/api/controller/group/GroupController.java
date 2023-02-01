package com.api.controller.group;

import com.api.controller.ApiResult;
import com.api.dto.CreateGroupRequest;
import com.api.dto.GroupDto;
import com.api.dto.UpdateGroupRequest;
import com.api.service.group.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.api.controller.ApiResult.OK;
import static com.api.controller.group.GroupMapper.toDto;
import static com.api.controller.group.GroupMapper.toEntity;
import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/group")
public class GroupController {

    private final GroupService groupService;

    // 전체 그룹 리스트 조회
    @GetMapping()
    public ApiResult<List<GroupDto>> getGroups() {
        return OK(
            groupService.findAll()
                    .stream()
                    .map(GroupMapper::toDto)
                    .collect(toList())
        );
    }

    // 그룹 아이디로 특정 그룹 조회
    @GetMapping("/{groupId}")
    public ApiResult<GroupDto> getGroup(@PathVariable Long groupId) {
        return OK(
            groupService.findById(groupId)
                    .map(GroupMapper::toDto)
                    .orElseThrow(() -> new RuntimeException("not found"))
        );
    }

    // 그룹 생성
    @PostMapping
    public ApiResult<GroupDto> createGroup(@RequestBody CreateGroupRequest request) {
        return OK(
            toDto(
                groupService.save(toEntity(request))
            )
        );
    }

    // 그룹 수정
    @PatchMapping
    public ApiResult<GroupDto> updateGroup(@RequestBody UpdateGroupRequest request) {
        return OK(
            toDto(
                groupService.updateGroup(toEntity(request))
            )
        );
    }

    // 그룹 삭제
    @DeleteMapping("/{groupId}")
    public ApiResult<GroupDto> deleteGroup(@PathVariable Long groupId) {
        return OK(
                toDto(groupService.deleteGroup(groupId))
        );
    }
}
