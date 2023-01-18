package com.api.controller.group;

import com.api.controller.ApiResult;
import com.api.dto.group.GroupDto;
import com.api.dto.group.GroupUpdateRequest;
import com.api.service.group.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.api.controller.ApiResult.OK;
import static com.api.controller.group.GroupMapper.toDto;
import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/group")
public class GroupController {

    private final GroupService groupService;

    // 그룹 조회
    @GetMapping
    public ApiResult<List<GroupDto>> getGroups(@PathVariable Integer categoryId) {
        return OK(
            groupService.findByCategoryId(categoryId)
                    .stream()
                    .map(GroupMapper::toDto)
                    .collect(toList())
        );
    }

    // 특정 그룹 조회
    @GetMapping("/{groupId}")
    public ApiResult<GroupDto> getGroup(@PathVariable Long groupId) {
        return OK(
            groupService.findById(groupId)
                    .map(GroupMapper::toDto)
                    .orElseThrow(() -> new RuntimeException("not found"))
        );
    }

    // 그룹 생성
    @PostMapping()
    public ApiResult<GroupDto> createGroup(@RequestBody GroupUpdateRequest request) {
        return OK(
            toDto(
                groupService.saveGroup(
                    request.newGroup(
                        request.getCategoryId(), request.getLeaderId(),
                        request.getName(), request.getDesc(),
                        request.getGroupImageUrl(), request.getPublicType(), request.getMaxNum(),
                        request.getCityId(), request.getTownId()
                    )
                )
            )
        );
    }

    // 그룹 수정
    @PutMapping("/{groupId}")
    public ApiResult<GroupDto> updateGroup(@RequestBody GroupDto groupDto) {
        return OK(

        );
    }

    // 그룹 삭제
    @DeleteMapping("/{groupId}")
    public Object deleteGroup(@PathVariable Long groupId) {
        return "{\n" +
                "   \"success\" : true, \n" +
                "   \"response\": [\n" +
                "       {\n" +
                "           \"groupId\": 0002401, \n" +
                "           \"categoryId\": 103, \n" +
                "           \"cityId\": 1, \n" +
                "           \"townId\": 8, \n" +
                "           \"maxNum\": 10, \n" +
                "           \"name\": \"서울특별시 서대문구 등산 모임\", \n" +
                "           \"desc\": \"등산러 모이세요\", \n" +
                "           \"profileImageUrl\": \"https://s3.console.aws.amazon.com/......jpeg\", \n" +
                "           \"masterId\": 0083212, \n" +
                "           \"modifyAt\": \"2022-12-22\", \n" +
                "           \"createAt\": \"2022-12-15\" \n" +
                "       } \n" +
                "   ], \n" +
                "   \"length\" : 1, \n" +
                "   \"error\" : null \n" +
                "}";
    }

    //그룹 포스팅 작성
    @PostMapping("/{groupId}/post")
    public Object groupPost() {
    	return null;
    }

    //그룹 포스팅 조회
    @GetMapping("/{groupId}/post/search")
    public Object groupPostSearch() {
    	return null;
    }

    //그룹 특정 포스팅 조회
    @GetMapping("/post/{postId}")
    public Object postIdSearch() {
    	return null;
    }

    //그룹 포스팅 수정
    @PutMapping("/update/{postId}")
    public Object postIdUpdate() {
    	return null;
    }

    //그룹 포스팅 삭제
    @DeleteMapping("/delete/{postId}")
    public Object postIdDelete() {
    	return null;
    }
}
