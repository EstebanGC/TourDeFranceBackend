package com.example.demo.repository;

import com.example.demo.entity.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CyclistRepository extends JpaRepository<Cyclist, Long> {
    public List<Cyclist> findByTeamId(Long teamId);
}
