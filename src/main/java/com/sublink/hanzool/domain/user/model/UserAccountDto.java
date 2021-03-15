package com.sublink.hanzool.domain.user.model;

public class UserAccountDto {

  private String id;
  private String email;
  private String username;
  private String password;

  public UserAccountDto() {
  }

  public UserAccountDto(String id, String email, String username, String password) {
    this.id = id;
    this.email = email;
    this.username = username;
    this.password = password;
  }

  public static UserAccountBuilder builder() {
    return new UserAccountBuilder();
  }

  public static class UserAccountBuilder {
    private String id;
    private String email;
    private String username;
    private String password;

    public UserAccountBuilder id(String id) {
      this.id = id;
      return this;
    }

    public UserAccountBuilder email(String email) {
      this.email = email;
      return this;
    }

    public UserAccountBuilder username(String username) {
      this.username = username;
      return this;
    }

    public UserAccountBuilder password(String password) {
      this.password = password;
      return this;
    }

    public UserAccountDto build() {
      UserAccountDto dto = new UserAccountDto();
      dto.id = this.id;
      dto.email = this.email;
      dto.username = this.username;
      dto.password = this.password;
      return dto;
    }
  }

  public String getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public UserAccount toEntity() {
    return new UserAccount(this.id, this.email, this.username, this.password);
  }

  public UserAccountDto of(UserAccount entity) {
    // @formatter:off
    return UserAccountDto
      .builder()
      .id(entity.getId())
      .email(entity.getEmail())
      .username(entity.getUsername())
      .password(entity.getPassword())
      .build();
    // @formatter:on
  }
}
