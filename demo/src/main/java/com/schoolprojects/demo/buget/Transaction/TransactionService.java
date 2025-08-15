package com.schoolprojects.demo.buget.Transaction;

import com.schoolprojects.demo.buget.DTO.TransactionDTO;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    // Converts a Transaction Entity to a TransactionDTO
    private TransactionDTO toDto(Transaction entity) {
        return new TransactionDTO(entity.getId(), entity.getCategory(), entity.getDate(), entity.getAmount(), entity.getDescription());
    }

    // Converts a TransactionDTO to a new Transaction Entity
    private Transaction toEntity(TransactionDTO dto) {
        // Note: We don't set the ID because this is for creating a new entity.
        return new Transaction(dto.getCategory(), dto.getDate(), dto.getAmount(), dto.getDescription());
    }

    public List<TransactionDTO> getAllTransactions() {
        return repository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public TransactionDTO getTransactionById(Long id) {
        return repository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new TransactionNotFoundException(id));
    }

    public TransactionDTO createTransaction(TransactionDTO newTransactionDto) {
        Transaction transaction = toEntity(newTransactionDto);
        Transaction savedTransaction = repository.save(transaction);
        return toDto(savedTransaction);
    }

    public TransactionDTO updateTransaction(Long id, TransactionDTO transactionDetailsDto) {
        return repository.findById(id)
                .map(transaction -> {
                    transaction.setCategory(transactionDetailsDto.getCategory());
                    transaction.setDate(transactionDetailsDto.getDate());
                    transaction.setAmount(transactionDetailsDto.getAmount());
                    transaction.setDescription(transactionDetailsDto.getDescription());
                    Transaction updatedTransaction = repository.save(transaction);
                    return toDto(updatedTransaction);
                })
                .orElseThrow(() -> new TransactionNotFoundException(id));
    }

    public void deleteTransaction(Long id) {
        if (!repository.existsById(id)) {
            throw new TransactionNotFoundException(id);
        }
        repository.deleteById(id);
    }
}