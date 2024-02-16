package org.formation.service;

import org.formation.dto.TransactionRequestDto;
import org.formation.dto.TransactionResponseDto;
import org.formation.dto.TransactionStatus;
import org.formation.entity.UserTransaction;
import org.formation.repository.UserRepository;
import org.formation.repository.UserTransactionRepository;
import org.formation.util.EntityDtoUtil;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {

	private UserRepository userRepository;
	private UserTransactionRepository transactionRepository;

	public TransactionService(UserRepository userRepository, UserTransactionRepository transactionRepository) {
		this.userRepository = userRepository;
		this.transactionRepository = transactionRepository;
	}

	public Mono<TransactionResponseDto> createTransaction(final TransactionRequestDto requestDto) {
		return this.userRepository.updateUserBalance(requestDto.getUserId(), requestDto.getAmount())
				.filter(Boolean::booleanValue)
				.map(b -> EntityDtoUtil.toEntity(requestDto))
				.flatMap(this.transactionRepository::save)
				.map(ut -> EntityDtoUtil.toDto(requestDto, TransactionStatus.APPROVED))
				.defaultIfEmpty(EntityDtoUtil.toDto(requestDto, TransactionStatus.DECLINED));
	}

	public Flux<UserTransaction> getByUserId(int userId) {
		return this.transactionRepository.findByUserId(userId);
	}

}
