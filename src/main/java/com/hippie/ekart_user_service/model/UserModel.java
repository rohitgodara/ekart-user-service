package com.hippie.ekart_user_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String userName;
    private String email;
    private String mobile;
    private String firstName;
    private String lastName;
}
