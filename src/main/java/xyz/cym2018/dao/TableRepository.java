package xyz.cym2018.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TableRepository extends JpaRepository<Tables, Integer> {
}
