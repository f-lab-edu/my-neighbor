package com.nb.api.controller.user;

import com.nb.api.dto.UserDto;
import com.nb.core.model.user.User;

public class UserMapper {

    public static UserDto toDto(User user) {
        return new UserDto(user.getUserId(), user.getEmail(), user.getName(),
                user.getRegionId(), user.getProfileImageUrl(), user.getLastLoginAt(),
                user.getCreateAt());
    }

}
