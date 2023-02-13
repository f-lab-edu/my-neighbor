package com.api.model.group;

import lombok.Getter;

public enum PostPublicType {
    PUBLIC("public"), /* 공개 포스팅 */
    MEMBER("member"); /* 멤버 공개 포스팅 */

    @Getter
    private final String value;

    PostPublicType(String value) {
        this.value = value;
    }
}
