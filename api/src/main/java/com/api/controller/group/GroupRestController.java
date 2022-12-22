package com.api.controller.group;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/group")
public class GroupRestController {

    // 그룹 조회
    @GetMapping
    public Object getGroups() {
        return "{\n" +
                "   \"success\" : true, \n" +
                "   \"response\": {\n" +
                "       \"groupList\":[\n" +
                "           {\n" +
                "               \"groupId\": 2401, \n" +
                "               \"categoryId\": 103, \n" +
                "               \"cityId\": 1, \n" +
                "               \"townId\": 8, \n" +
                "               \"maxNum\": 150, \n" +
                "               \"name\": \"서울특별시 서대문구 산악회\", \n" +
                "               \"desc\": \"서대문구 등산러 모여라\", \n" +
                "               \"profileImageUrl\": \"https://s3.console.aws.amazon.com/......jpeg\", \n" +
                "               \"masterId\": 83212, \n" +
                "               \"modifyAt\": \"2022-12-15\", \n" +
                "               \"createAt\": \"2022-12-15\", \n" +
                "           }, \n" +
                "           {\n" +
                "               \"groupId\": 5, \n" +
                "               \"categoryId\": 10, \n" +
                "               \"cityId\": 4, \n" +
                "               \"townId\": 2, \n" +
                "               \"maxNum\": 20, \n" +
                "               \"name\": \"강원도 춘천시 닭갈비 탐험대\", \n" +
                "               \"desc\": \"닭갈비를 사랑하는 사람들\", \n" +
                "               \"profileImageUrl\": \"https://s3.console.aws.amazon.com/......jpeg\", \n" +
                "               \"masterId\": 673, \n" +
                "               \"modifyAt\": \"2022-05-10\", \n" +
                "               \"createAt\": \"2002-12-12\", \n" +
                "           }, \n" +
                "       ], \n" +
                "   \"error\" : null \n" +
                "}";
    }

    // 특정 그룹 조회
    @GetMapping("/{groupId}")
    public Object getOneGroup(@PathVariable Long groupId) {
        return "{\n" +
                "   \"success\" : true, \n" +
                "   \"response\": {\n" +
                "       \"group\" : {\n" +
                "           \"groupId\": " + groupId + ", \n" +
                "           \"categoryId\": 103, \n" +
                "           \"cityId\": 1, \n" +
                "           \"townId\": 7, \n" +
                "           \"maxNum\": 15, \n" +
                "           \"name\": \"서울특별시 동대문구 방탈출 모임\", \n" +
                "           \"desc\": \"방을 탈출하자\", \n" +
                "           \"profileImageUrl\": \"https://s3.console.aws.amazon.com/......jpeg\", \n" +
                "           \"masterId\": 0025345, \n" +
                "           \"modifyAt\": \"2022-03-20\", \n" +
                "           \"createAt\": \"2021-02-15\", \n" +
                "           }, \n" +
                "       }, \n" +
                "   \"error\" : null \n" +
                "}";
    }

    // 그룹 생성
    @PostMapping("/create")
    public Object createGroup(GroupDto groupDto) {
        return "{\n" +
                "   \"success\" : true, \n" +
                "   \"response\": {\n" +
                "       \"group\" : {\n" +
                "           \"groupId\": 0002401, \n" +
                "           \"categoryId\": 103, \n" +
                "           \"cityId\": 1, \n" +
                "           \"townId\": 8, \n" +
                "           \"maxNum\": 10, \n" +
                "           \"name\": \"서울특별시 서대문구 산악회\", \n" +
                "           \"desc\": \"서대문구 등산러 모여라\", \n" +
                "           \"profileImageUrl\": \"https://s3.console.aws.amazon.com/......jpeg\", \n" +
                "           \"masterId\": 0083212, \n" +
                "           \"modifyAt\": \"2022-12-22\", \n" +
                "           \"createAt\": \"2022-12-22\", \n" +
                "           }, \n" +
                "       }, \n" +
                "   \"error\" : null \n" +
                "}";
    }

    // 그룹 수정
    @PutMapping("/{groupId}/update")
    public Object updateGroup(@PathVariable Long groupId) {
        return "{\n" +
                "   \"success\" : true, \n" +
                "   \"response\": {\n" +
                "       \"group\" : {\n" +
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
                "           \"createAt\": \"2022-12-15\", \n" +
                "           }, \n" +
                "       }, \n" +
                "   \"error\" : null \n" +
                "}";
    }

    // 그룹 삭제
    @DeleteMapping("/{groupId}/delete")
    public Object deleteGroup(@PathVariable Long groupId) {
        return "{\n" +
                "   \"success\" : true, \n" +
                "   \"response\": \"" + groupId + " has been deleted.\", \n" +
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
