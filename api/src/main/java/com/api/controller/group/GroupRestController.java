package com.api.controller.group;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/group")
public class GroupRestController {

	//그룹 생성
    @PostMapping
    public Object group() {
    	return null;
    }

    //그룹 조회
    @GetMapping("/search")
    public Object groupSearch() {
    	return null;
    }

    //특정 그룹 조회
    @GetMapping("/{groupId}")
    public Object groupIdSearch() {
    	return null;
    }

    //그룹 수정
    @PutMapping("/{groupId}/update")
    public Object groupUpdate() {
    	return null;
    }

    //그룹 삭제
    @DeleteMapping("/{groupId}/delete")
    public Object groupDelete() {
    	return null;
    }ß

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
    @GetMapping("/{groupId}/{postId}")
    public Object postIdSearch() {
    	return null;
    }

    //그룹 포스팅 수정
    @PutMapping("/{groupId}/{postId}/update")
    public Object postIdUpdate() {
    	return null;
    }
    //그룹 포스팅 삭제
    @DeleteMapping("/{groupId}/{postId}/delete")
    public Object postIdDelete() {
    	return null;
    }
}