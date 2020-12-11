package com.ccs.repository;

import com.ccs.model.Exchange;
import com.ccs.service.CurrencyPairs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {


    @Query("select distinct e.userId from exchange e " +
            "where e.dollarAmount > 10000 order by e.userId asc")
    public List<Long> getUserByDollarAmount();

    @Query("select e.originalCurrency, e.targetCurrency, count(e) as counter from exchange e group by" +
            " e.originalCurrency, e.targetCurrency order by counter desc")
    public List<CurrencyPairs> getSortedPair();

    @Query("select exchange.userId, sum(exchange.dollarAmount)" +
            "from exchange exchange group by exchange.userId order by exchange.userId asc")
    public List<Map<Long, BigDecimal>> getUserAllExchangesAmount();

    @Query("select exchange.originalCurrency, exchange.targetCurrency, exchange.id from exchange exchange where id=1")
    public CurrencyPairs findCurrencyPairs();
}
