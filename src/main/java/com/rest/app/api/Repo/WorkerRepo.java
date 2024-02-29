package com.rest.app.api.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rest.app.api.Models.Workers;

public interface WorkerRepo extends JpaRepository<Workers, Long> {
}
