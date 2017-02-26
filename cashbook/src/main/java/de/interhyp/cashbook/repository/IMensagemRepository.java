package de.interhyp.cashbook.repository;

import de.interhyp.cashbook.model.BookingEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by odyssefs on 26.02.17.
 */
public interface IMensagemRepository extends MongoRepository<BookingEntry, String> {

}
