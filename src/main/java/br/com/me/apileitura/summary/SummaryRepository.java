package br.com.me.apileitura.summary;

import org.springframework.data.jpa.repository.JpaRepository;

interface SummaryRepository extends JpaRepository<Summary,Long> {
}
