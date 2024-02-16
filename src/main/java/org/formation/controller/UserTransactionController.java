package org.formation.controller;

import org.formation.dto.TransactionRequestDto;
import org.formation.dto.TransactionResponseDto;
import org.formation.entity.UserTransaction;
import org.formation.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user/transaction")
public class UserTransactionController {

	private TransactionService transactionService;

	public UserTransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@PostMapping
	public Mono<TransactionResponseDto> createTransaction(@RequestBody Mono<TransactionRequestDto> requestDtoMono) {
		return requestDtoMono.flatMap(this.transactionService::createTransaction);
	}

	@GetMapping
	public Flux<UserTransaction> getByUserId(@RequestParam("userId") int userId) {
		return this.transactionService.getByUserId(userId);
	}

}
