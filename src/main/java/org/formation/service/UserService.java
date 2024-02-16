package org.formation.service;

import org.formation.dto.UserDto;
import org.formation.repository.UserRepository;
import org.formation.util.EntityDtoUtil;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService implements IUserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Flux<UserDto> all() {
		return this.userRepository.findAll().map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<UserDto> getUserById(final int userId) {
		return this.userRepository.findById(userId).map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<UserDto> createUser(Mono<UserDto> userDtoMono) {
		return userDtoMono.map(EntityDtoUtil::toEntity).flatMap(this.userRepository::save).map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<UserDto> updateUser(int id, Mono<UserDto> userDtoMono) {
		return this.userRepository.findById(id)
				.flatMap(u -> userDtoMono.map(EntityDtoUtil::toEntity).doOnNext(e -> e.setId(id)))
				.flatMap(this.userRepository::save).map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<Void> deleteUser(int id) {
		return this.userRepository.deleteById(id);
	}

}
