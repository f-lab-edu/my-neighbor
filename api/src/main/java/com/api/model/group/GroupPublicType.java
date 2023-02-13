package com.api.model.group;

import lombok.Getter;

public enum GroupPublicType {
    PUBLIC("public"), /* 공개 그룹 */
    PUBLIC_APPROVAL("public_approval"), /* 공개 그룹(가입 승인) */
    PRIVATE("private"); /* 비공개 그룹 */

    @Getter
    private final String value;

    GroupPublicType(String value) {
        this.value = value;
    }
}
