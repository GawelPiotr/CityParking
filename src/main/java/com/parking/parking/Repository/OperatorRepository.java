package com.parking.parking.Repository;

import com.parking.parking.Model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<Operator, Integer> {

    Operator findByLogin(String login);

}
