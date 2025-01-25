package com.forcen.e_vote.mapper;

    import com.forcen.e_vote.dtos.UserDTO;

    import com.forcen.e_vote.entities.User;

    //MapStruct Mapper
    import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDto);
}