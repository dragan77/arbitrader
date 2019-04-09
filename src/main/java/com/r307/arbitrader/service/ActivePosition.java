package com.r307.arbitrader.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;

import java.math.BigDecimal;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ActivePosition {
    private Trade longTrade = new Trade();
    private Trade shortTrade = new Trade();
    private CurrencyPair currencyPair;
    private BigDecimal exitTarget;

    public Trade getLongTrade() {
        return longTrade;
    }

    public Trade getShortTrade() {
        return shortTrade;
    }

    public CurrencyPair getCurrencyPair() {
        return currencyPair;
    }

    public void setCurrencyPair(CurrencyPair currencyPair) {
        this.currencyPair = currencyPair;
    }

    public BigDecimal getExitTarget() {
        return exitTarget;
    }

    public void setExitTarget(BigDecimal exitTarget) {
        this.exitTarget = exitTarget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActivePosition)) return false;
        ActivePosition that = (ActivePosition) o;
        return Objects.equals(getLongTrade(), that.getLongTrade()) &&
            Objects.equals(getShortTrade(), that.getShortTrade()) &&
            Objects.equals(getCurrencyPair(), that.getCurrencyPair()) &&
            Objects.equals(getExitTarget(), that.getExitTarget());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLongTrade(), getShortTrade(), getCurrencyPair(), getExitTarget());
    }

    public static class Trade {
        private String exchange;
        private String orderId;
        private BigDecimal volume;
        private BigDecimal entry;

        public String getExchange() {
            return exchange;
        }

        public void setExchange(String exchange) {
            this.exchange = exchange;
        }

        public void setExchange(Exchange exchange) {
            this.exchange = exchange.getExchangeSpecification().getExchangeName();
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public BigDecimal getVolume() {
            return volume;
        }

        public void setVolume(BigDecimal volume) {
            this.volume = volume;
        }

        public BigDecimal getEntry() {
            return entry;
        }

        public void setEntry(BigDecimal entry) {
            this.entry = entry;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Trade)) return false;
            Trade trade = (Trade) o;
            return Objects.equals(getExchange(), trade.getExchange()) &&
                Objects.equals(getOrderId(), trade.getOrderId()) &&
                Objects.equals(getVolume(), trade.getVolume()) &&
                Objects.equals(getEntry(), trade.getEntry());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getExchange(), getOrderId(), getVolume(), getEntry());
        }
    }
}