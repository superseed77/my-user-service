package org.formation.service;

import org.formation.dto.UserDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {

	Flux<UserDto> all();

	Mono<UserDto> getUserById(int userId);

	Mono<UserDto> createUser(Mono<UserDto> userDtoMono);

	Mono<UserDto> updateUser(int id, Mono<UserDto> userDtoMono);

	Mono<Void> deleteUser(int id);

}