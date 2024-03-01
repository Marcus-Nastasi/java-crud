package com.rest.app.api.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rest.app.api.Models.Workers;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepo extends JpaRepository<Workers, Long> {
}
