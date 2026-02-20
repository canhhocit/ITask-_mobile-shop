package com.stu.mobile_shop.domains;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class User {
    Long id;
    String email; 
    String password;
    String fullName;
    String address;
    String phone;
}
