package org.formation.repository;

import org.formation.entity.UserTransaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;


public interface UserTransactionRepository extends ReactiveCrudRepository<UserTransaction, Integer> {

    Flux<UserTransaction> findByUserId(int userId);

}
